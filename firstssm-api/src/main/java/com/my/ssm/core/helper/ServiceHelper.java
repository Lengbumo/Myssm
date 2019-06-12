package com.my.ssm.core.helper;

import com.my.ssm.core.util.PConst;

/**
 * 手动注入services
 * 
 * @ClassName  ServiceHelper        
 * 
 * @author WJ
 * @date   2019年5月15日 上午10:38:18   
 *
 */
public class ServiceHelper {

	/**
	 * 手动注入Service
     * 
	 * 
	 * @Title getService    
	 * @param serviceName 需要注入的类名
     * @return 返回对象       
	 *  
	 * @author WJ
	 * @date   2019年5月15日 上午10:38:36
	 */
    public static Object getService(String serviceName) {
        return PConst.WEB_APP_CONTEXT.getBean(serviceName);
    }

    /**
     * 手动注入Service
     * 
     * 
     * @Title getService    
     * @param cls 需要注入的Class
     * @return 返回对象 
     *  
     * @author WJ
     * @date   2019年5月15日 上午10:38:54
     */
    public static Object getService(Class<?> cls) {
        return PConst.WEB_APP_CONTEXT.getBean(cls);
    }
}
