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

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.my.ssm.core.util.ContextUtil;
import com.my.ssm.core.util.PConst;
import com.my.ssm.sec.model.UserDetailsBeanModel;

/**
 * @com.sl.pt.core.listener.WebAppSessionListener.java
 * @remark WebAppSessionListener
 * @author system
 * @email system@shuangling-tech.com
 * @version 1.0
 * @since JDK 1.7 
 * @create time 2017-10-23 下午2:43:15
 */
public class WebAppSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        Authentication authenticate = (Authentication) arg0.getSession().getAttribute(PConst._SECURITY_USER);
        if (authenticate != null) {
            UserDetailsBeanModel principal = (UserDetailsBeanModel) authenticate.getPrincipal();
            if (principal != null) {
                try {
                	// 用户日志记录
                    /*UserLogsService userLogsService = (UserLogsService) ServiceHelper.getService(UserLogsService.class);
                    if (userLogsService != null) {
                        BrowserUtil.setBrowser(HttpServletRequestUtil.getServletRequest());

                        
                        UserLogs record = new UserLogs();
                        record.setLogoutType(PConsts.OPERATOR_LOGOUT_BY_OT);
                        userLogsService.execLogout(record);
                    }*/
                } catch (Exception e) {
                }
            }
        }

        // 销毁当前session
        ContextUtil.setServletRequest(null);
        ContextUtil.setServletResponse(null);
        SecurityContextHolder.clearContext();
    }
}
