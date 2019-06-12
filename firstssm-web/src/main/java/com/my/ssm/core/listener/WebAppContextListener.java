/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.core.listener;

import com.my.ssm.core.cache.CacheManager;
import com.my.ssm.core.helper.ServiceHelper;
import com.my.ssm.core.util.PConst;
import com.my.ssm.core.util.ToolsUtil;
import com.my.ssm.sys.pojo.MenuPojo;
import com.my.ssm.sys.service.MenuService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

/**
 * @com.sl.pt.core.listener.WebAppContextListener.java
 * @remark WebAppContextListener
 * @author system
 * @email system@shuangling-tech.com
 * @version 1.0
 * @since JDK 1.7 
 * @create time 2017-10-23 下午2:44:53
 */
public class WebAppContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        ServletContext servletContext = arg0.getServletContext();
        servletContext.removeAttribute(PConst.APP_CTX);
        servletContext.removeAttribute(PConst.APP_WEBNAME);
        servletContext.removeAttribute(PConst.APP_KEYWORDS);
        servletContext.removeAttribute(PConst.APP_DESCRIPTION);
        servletContext.removeAttribute(PConst.APP_WEBLINK);

        PConst.WEB_APP_CONTEXT = null;
        SecurityContextHolder.clearContext();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext sc = arg0.getServletContext();
        sc.setAttribute(PConst.APP_CTX, sc.getContextPath());

        // 赋值全局Ctx
        PConst.WEB_APP_CONTEXT = WebApplicationContextUtils.getWebApplicationContext(sc);
        PConst.APP_CTX_VALUE = sc.getContextPath();

        // INIT APP
        initAppInfo(sc);
        
        // 菜单按钮缓存
        initMenuInfoCach();
        

    }

    /**INIT APP*/
    private void initAppInfo(ServletContext sc) {
        try {
            ClassPathResource resource = new ClassPathResource("appconfig.properties");
            Properties properties = new Properties();
            BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
            properties.load(bf);

            // 处理基本信息
            sc.setAttribute(PConst.APP_KEYWORDS, properties.get(PConst.APP_KEYWORDS_KEY));
            sc.setAttribute(PConst.APP_DESCRIPTION, properties.get(PConst.APP_DESCRIPTION_KEY));
            sc.setAttribute(PConst.APP_WEBLINK, properties.get(PConst.APP_WEBLINK_KEY));
            sc.setAttribute(PConst.APP_WEBNAME, properties.get(PConst.APP_WEBNAME_KEY));
            sc.setAttribute(PConst.APP_WEBLOGO, properties.get(PConst.APP_WEBLOGO_KEY));
            sc.setAttribute(PConst.JS_VERSION, properties.get(PConst.JS_VERSION_KEY));
            sc.setAttribute(PConst.CSS_VERSION, properties.get(PConst.CSS_VERSION_KEY));

        } catch (Exception e) {
        	
        }
    }

    /** 缓存菜单及按钮 */
    private void initMenuInfoCach() {
    	MenuService menuService = (MenuService)ServiceHelper.getService(MenuService.class);
    	List<MenuPojo> listMenu = menuService.listMenu();
    	
    	// 初始化缓存
    	CacheManager.getInstance().init(listMenu.size());
    	
    	// 将菜单及按钮放入缓存池中
    	for (MenuPojo menu : listMenu) {
			String key = menu.getMenuUrl();
			
			if (ToolsUtil.isNotNull(key)) {
				CacheManager.getInstance().putMenu(key, menu);
			}
		}
    }

}
