/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.my.ssm.core.util.ContextUtil;

/**
 * 自定义拦截器
 * 
 * @ClassName  ThreadLocalInterceptor        
 * 
 * @author WJ
 * @date   2019年4月18日 上午11:54:10   
 *
 */
public class ThreadLocalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        WebApplicationContext appContext = RequestContextUtils.getWebApplicationContext(request);
        ContextUtil.setServletRequest(request);
        ContextUtil.setServletResponse(response);
        ContextUtil.setApplicationContext(appContext);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        ContextUtil.setServletRequest(null);
        ContextUtil.setServletResponse(null);
        ContextUtil.setApplicationContext(null);
        SecurityContextHolder.clearContext();
    }

}
