/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.ctl.sec.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.my.ssm.core.cache.CacheManager;
import com.my.ssm.core.util.BrowserUtil;
import com.my.ssm.core.util.DateUtil;
import com.my.ssm.core.util.PConst;
import com.my.ssm.core.util.ToolsUtil;
import com.my.ssm.sec.model.BrowserModel;
import com.my.ssm.sec.util.MiscUtil;
import com.my.ssm.sys.model.OperationLog;
import com.my.ssm.sys.pojo.MenuPojo;
import com.my.ssm.sys.service.OperationLogService;

/**
 * 自定义拦截器
 * 
 * @ClassName  SecurityFilter        
 * 
 * @author WJ
 * @date   2019年4月26日 上午9:51:29   
 *
 */
public class SecurityFilter extends OncePerRequestFilter {
    protected static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

    private PathMatcher pathMatcher = new AntPathMatcher();
    private List<String> assets;
    private List<String> excludes;

    private String loginUrl;
    private String homePageUrl;
    private String secUrl;
    private SessionRegistry sessionRegistry;
    private Map<String, String> patterns;

	private Map<String, String> omap;
	@Autowired
    private OperationLogService operationLogService;

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        Assert.notNull(this.excludes, "A excludes is required");
        Assert.notNull(this.assets, "A assets must be set");
        Assert.notNull(this.pathMatcher, "A pathMatcher is required");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 忽略静态页面
        if (isIgnoreUrl(request, response, assets)) {
            filterChain.doFilter(request, response);
            return;
        }

        // 初始化容器
        initSecurityContext(request, response);

        // 记录日志
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        if (ToolsUtil.isNotNull(queryString)) {
            logger.debug("Access {}?{}", requestURI, queryString);
        } else {
            logger.debug("Access {}", requestURI);
        }

        // 非验证行URL地址处理
        if (!requestURI.contains(secUrl)) {
            if (requestURI.contains(loginUrl) && isLogin(request, response)) {
                sendRedirectWebHomePageUrl(request, response);
                return;
            } else {
                // 忽略绑定页面
                if (isIgnoreUrl(request, response, excludes)) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }

            if (!isLogin(request, response)) {
                sendRedirectLoginUrl(request, response);
                return;
            }
        }

        HttpSession session = request.getSession(false);
        if (session == null) {
            // 重定向到登录页面
            sendRedirectLoginUrl(request, response);
            return;
        } else {
            // 初始化权限
            initAuthentication(request, response);
            if (!isLogin(request, response)) {
                SessionInformation info = sessionRegistry.getSessionInformation(session.getId());
                if (info != null) {
                    if (info.isExpired()) {
                        logger.debug("Session expired");
                        // 重定向到登录页面
                        sendRedirectLoginUrl(request, response);
                        return;
                    } else {
                        // 刷新Session
                        sessionRegistry.refreshLastRequest(info.getSessionId());

                        // 处理授权
                        if (!authorize(request, response)) {
                            logger.debug("No authority to access URL: " + request.getRequestURI());
                            return;
                        }
                    }
                } else {
                    // 重定向到登录页面
                    sendRedirectLoginUrl(request, response);
                    return;
                }
            }
        }

        // 记录操作日志
        String url = splitUrl(requestURI, request.getContextPath());
        MenuPojo menu = CacheManager.getInstance().getMenu(url);
        if (null != menu) {
        	// 获取用户IP
    		String realIp = BrowserUtil.getIpAddr(request);
    		// 获取用户浏览器信息
    		BrowserModel broModel = BrowserUtil.getUserAgentModel(request);
        	OperationLog opLog = new OperationLog();
        	opLog.setOperModuleCode(menu.getModuleCode());
        	opLog.setOperMenuCode(menu.getMenuCode());
    		opLog.setOperMenuDesc(menu.getMenuName());
    		// 请求地址
    		opLog.setOperDesc(url);
    		opLog.setOperIp(realIp);
    		opLog.setOperDate(DateUtil.getNow());
    		opLog.setBrowserType(broModel.getBroType());
    		opLog.setBrowserVersion(broModel.getBroversion());
    		opLog.setUserCode(MiscUtil.getUserCode());
    		opLog.setUserName(MiscUtil.getUserNameZ());
    		// 操作描述
    		if (ToolsUtil.isNotNull(menu.getOperionName())) {
    			opLog.setOperMethod(String.format("点击【%s】", menu.getOperionName()));
    		} else {
    			opLog.setOperMethod(String.format("点击【%s】", menu.getMenuName()));
    		}
    		
    		operationLogService.insertSelective(opLog);
        }
        
        // 继续处理业务逻辑
        filterChain.doFilter(request, response);
    }

    private void initSecurityContext(HttpServletRequest request, HttpServletResponse response) {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
            SecurityContextHolder.setContext(emptyContext);
        }
    }

    /** URL处理 将带参数的URL截取掉后续参数*/
    private String splitUrl(String requestURI, String contextPath) {
    	// 去掉项目路径
        requestURI = requestURI.replace(contextPath, "");
        for (Map.Entry<String, String> entry : omap.entrySet()) {
            String value = entry.getKey();
            if (requestURI.indexOf(value) > 0) {
                return requestURI.substring(0, requestURI.lastIndexOf("?") + 1);
            }
        }

        return requestURI;
    }

    private boolean isIgnoreUrl(HttpServletRequest request, HttpServletResponse response, List<String> ignores) {
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        if (requestURI.contains(";")) { //去掉jsessionid信息
            requestURI = requestURI.split(";")[0];
        }

        for (String pattern : ignores) {
            if (!ToolsUtil.isNull(contextPath)) {
                pattern = contextPath + pattern;
            }

            if (pathMatcher.match(pattern, requestURI)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 验证用户是否已经登录
     * 
     * @Title isLogin    
     * @param request
     * @param response
     * @return          
     *  
     * @author WJ
     * @date   2019年4月26日 上午9:54:26
     */
    private boolean isLogin(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute(PConst._SECURITY_USER) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户权限验证
     * 
     * @Title authorize    
     * @param request
     * @param response
     * @return
     * @throws IOException          
     *  
     * @author WJ
     * @date   2019年4月26日 上午9:54:44
     */
    private boolean authorize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            sendRedirectLoginUrl(request, response);
            return false;
        }

        String access = getAccess(request);
        if (ToolsUtil.isNull(access)) {
            return true;
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority auth : authorities) {
            String authority = auth.getAuthority();

            if (authority.equals(access)) {
                return true;
            }
        }

        response.sendError(404);

        return false;
    }

    private String getAccess(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();

        Set<Entry<String, String>> entrySet = patterns.entrySet();
        for (Entry<String, String> entry : entrySet) {
            String pattern = entry.getKey();
            if (!ToolsUtil.isNull(contextPath)) {
                pattern = contextPath + pattern;
            }

            if (pathMatcher.match(pattern, requestURI)) {
                return entry.getValue();
            }
        }

        return null;
    }

    private void initAuthentication(HttpServletRequest request, HttpServletResponse response) {
        SecurityContext context = SecurityContextHolder.getContext();
        HttpSession session = request.getSession();
        Authentication authentication = (Authentication) session.getAttribute(PConst._SECURITY_USER);
        context.setAuthentication(authentication);
    }

    private void sendRedirectWebHomePageUrl(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Redirect to Web HomePage Url");
        try {
            String contextPath = request.getContextPath();
            response.sendRedirect(
                    contextPath + homePageUrl + "?scope=system;jsessionid=" + request.getSession().getId());
        } catch (Exception e) {
            logger.error("sendRedirectWebHomePageUrl()-", e);
        }
    }

    private void sendRedirectLoginUrl(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Redirect to Login Url");
        try {
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + loginUrl);
        } catch (Exception e) {
            logger.error("sendRedirectLoginUrl()-", e);
        }
    }

    /*private void sendRedirectLoginUrl4Fail(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Redirect to Login Url");
        try {
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + loginUrl + "?error=1");
        } catch (Exception e) {
            logger.error("sendRedirectLoginUrl4Fail()-", e);
        }
    }*/

    //***************************GET/SET*******************************
    public void setPathMatcher(PathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
    }

    public void setAssets(List<String> assets) {
        this.assets = assets;
    }

    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public void setSecUrl(String secUrl) {
        this.secUrl = secUrl;
    }

    public void setSessionRegistry(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void setPatterns(Map<String, String> patterns) {
        this.patterns = patterns;
    }

	public void setOmap(Map<String, String> omap) {
		this.omap = omap;
	}

}
