/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.ctl.sec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.ssm.core.exception.BizException;
import com.my.ssm.core.util.AppRespUtil;
import com.my.ssm.core.util.BrowserUtil;
import com.my.ssm.core.util.PConst;
import com.my.ssm.core.util.RandomValidateCodeUtil;
import com.my.ssm.sec.model.BrowserModel;
import com.my.ssm.sec.model.LoginModel;
import com.my.ssm.sec.service.SecurityService;
import com.my.ssm.sys.service.OperationLogService;

/**
 * 登陆
 * 
 * @ClassName  LoginController        
 * 
 * @author WJ
 * @date   2019年4月18日 下午4:54:34   
 *
 */
@Controller
@RequestMapping(value = "/myssm")
public class LoginController {
    protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private transient SecurityService securityService;
    @Autowired
    private transient SessionRegistry sessionRegistry;
    @Autowired
    private OperationLogService operationLogService;

    /**
     * 去用户登录界面
     * 
     * @return
     *
     * @author system
     * @remark 方法初始化
     * @create time 2017-10-23 下午3:45:01
     */
    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "/login/login";
    }

    /**
     * 用户登录
     * 
     * @Title login    
     * @param lv
     * @param mv
     * @param session
     * @param request
     * @return          
     *  
     * @author WJ
     * @date   2019年4月18日 下午5:26:58
     */
    @RequestMapping(value = "login/in", method = {RequestMethod.POST})
    @ResponseBody
    public AppRespUtil login(LoginModel lv, ModelAndView mv, HttpSession session, HttpServletRequest request) {
        try {
        	String codeSession = null;
        	// 获取验证码
            if (null != session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY)) {
                codeSession = session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY).toString();
            }

            String code = lv.getVerifycode() == null ? "" : lv.getVerifycode();
            codeSession = codeSession == null ? "" : codeSession;

            // 判断验证码是否正确
            if (code.equals(codeSession)) {
            	BrowserModel browser = BrowserUtil.getUserAgentModel(request);
                lv.setBvo(browser);
                logger.debug(String.format("浏览器类型是%s,版本为%s", browser.getBroType(), browser.getBroversion()));
                
                // 用户信息认证
                Authentication authenticate = securityService.authenticate(lv);
                sessionRegistry.registerNewSession(session.getId(), authenticate.getAuthorities());
                session.setAttribute(PConst._SECURITY_USER, authenticate);
                return AppRespUtil.ok();
            } else {
            	return AppRespUtil.fail("E10000", "验证码错误");
            }
        } catch (BizException e) {
            logger.error("LoginController login()->", e);
            return AppRespUtil.fail(e.getErrCode(), e.getMessage());
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            logger.error("LoginController login()->", e);
            return AppRespUtil.fail("E00000", e.getMessage());
        } catch (Exception e) {
            logger.error("LoginController login()->", e);
            return AppRespUtil.fail("E00000", "系统异常");
        }
    }

    /**
     * 用户退出系统
     * 
     * @Title logout    
     * @param session
     * @param request
     * @return          
     *  
     * @author WJ
     * @date   2019年4月18日 下午5:27:20
     */
    @RequestMapping(value = "logout", method = {RequestMethod.GET})
    public String logout(HttpSession session, HttpServletRequest request) {
        // 设置请求信息
        BrowserUtil.setBrowser(request);

        // 写入退出日志
        operationLogService.execLogOut();

        // 移除Session信息
        session.removeAttribute(PConst._SECURITY_USER);
        SecurityContextHolder.getContext().setAuthentication(null);
        sessionRegistry.removeSessionInformation(session.getId());

        return "redirect:/login";
    }
    
    /**
     * 获取随机验证码
     * 
     * @Title getRadomCode    
     * @param session
     * @param request
     * @param response
     * @return          
     *  
     * @author WJ
     * @date   2019年4月25日 下午5:06:32
     */
    @RequestMapping(value = "getRadomCode", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AppRespUtil getRadomCode(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
        	response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
    		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
    		response.setHeader("Cache-Control", "no-cache");
    		response.setDateHeader("Expire", 0);
    		RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
    		try {
    			randomValidateCode.getRandcode(request, response);// 输出图片方法
    		} catch (Exception e) {
    			e.printStackTrace();
    		}

            return AppRespUtil.ok();
        } catch (BizException e) {
            logger.error("LoginController getRadomCode()->", e);
            return AppRespUtil.fail(e.getErrCode(), e.getMessage());
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            logger.error("LoginController getRadomCode()->", e);
            return AppRespUtil.fail("E00000", e.getMessage());
        } catch (Exception e) {
            logger.error("LoginController getRadomCode()->", e);
            return AppRespUtil.fail("E00000", "系统异常");
        }
    }

}
