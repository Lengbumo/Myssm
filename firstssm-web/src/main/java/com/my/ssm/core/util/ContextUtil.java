/**
 *    Copyright 2017-2017 Shanghai ShuangLing Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact: http://www.shuangling-tech.cn/
 */
package com.my.ssm.core.util;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 存放服务信息容器
 * 
 * @ClassName  ContextUtil        
 * 
 * @author WJ
 * @date   2019年4月18日 上午11:53:19   
 *
 */
public class ContextUtil {

    private static final ThreadLocal<ApplicationContext> txApplicationContext = new ThreadLocal<ApplicationContext>();
    private static final ThreadLocal<HttpServletRequest> txServletRequest = new ThreadLocal<HttpServletRequest>();
    private static final ThreadLocal<HttpServletResponse> txServletResponse = new ThreadLocal<HttpServletResponse>();

    public static void setApplicationContext(ApplicationContext paramApplicationContext) {
        txApplicationContext.set(paramApplicationContext);
    }

    public static ApplicationContext getApplicationContext() {
        return ((ApplicationContext) txApplicationContext.get());
    }

    public static void setServletRequest(HttpServletRequest paramHttpServletRequest) {
        txServletRequest.set(paramHttpServletRequest);
    }

    public static HttpServletRequest getServletRequest() {
        return ((HttpServletRequest) txServletRequest.get());
    }

    public static void setServletResponse(HttpServletResponse paramHttpServletResponse) {
        txServletResponse.set(paramHttpServletResponse);
    }

    public static HttpServletResponse getServletResponse() {
        return ((HttpServletResponse) txServletResponse.get());
    }

    public static Object getBean(String paramString) {
        return getApplicationContext().getBean(paramString);
    }

    public static <T> T getBean(String paramString, Class<T> paramClass) {
        return getApplicationContext().getBean(paramString, paramClass);
    }

    public static <T> T getBean(Class<T> paramClass) {
        return getApplicationContext().getBean(paramClass);
    }

    public static Locale getLocale() {
        LocaleResolver localLocaleResolver = (LocaleResolver) getApplicationContext().getBean(LocaleResolver.class);
        HttpServletRequest localHttpServletRequest = getServletRequest();
        return localLocaleResolver.resolveLocale(localHttpServletRequest);
    }

    public static void setLocale(Locale paramLocale) {
        LocaleResolver localLocaleResolver = (LocaleResolver) getApplicationContext().getBean(LocaleResolver.class);
        HttpServletRequest localHttpServletRequest = getServletRequest();
        HttpServletResponse localHttpServletResponse = getServletResponse();
        localLocaleResolver.setLocale(localHttpServletRequest, localHttpServletResponse, paramLocale);
    }

    public static String getMessage(String paramString) {
        return getMessage(paramString, new Object[0]);
    }

    public static String getMessage(String paramString, List<Object> paramList) {
        return getMessage(paramString, paramList.toArray());
    }

    public static String getMessage(String paramString, Object[] paramArrayOfObject) {
        ApplicationContext localApplicationContext = getApplicationContext();
        Locale localLocale = getLocale();
        return localApplicationContext.getMessage(paramString, paramArrayOfObject, localLocale);
    }

    public static String getI18NMessage(String paramString1, String paramString2) {
        paramString2 = getMessage(paramString2);
        return getMessage(paramString1, new Object[]{paramString2});
    }

}
