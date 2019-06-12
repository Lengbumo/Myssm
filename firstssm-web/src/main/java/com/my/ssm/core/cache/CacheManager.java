/**
 *    Copyright 2018-2018 Shanghai ShuangLing Network Technology Co., Ltd.
 *
 *    Unless required by applicable law or agreed to in writing,software
 *    distributed under the version 1.0 of this code,
 *    without warranties or conditions of any kind, either express or implied.
 *      
 *    Have questions, please contact:
 *       wsite: http://shuangling-tech.com/
 *		 email: info@shuangling-tech.com
 *    
 *	  File name: CacheManager.java   
 *    version 1.0.0
 */
package com.my.ssm.core.cache;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.my.ssm.sys.pojo.MenuPojo;

/**
 * 缓存操作
 * 
 * @ClassName  CacheManager        
 * 
 * @author WJ
 * @date   2019年4月18日 上午11:58:13   
 *
 */
public class CacheManager implements InitializingBean, DisposableBean {

    private static CacheManager instance;
    private CacheMenuManager cacheMenu;

    /** 初始化缓存 */
    public void init(int capacity) {
    	cacheMenu = new CacheMenuManager(capacity);
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    @Override
	public void destroy() throws Exception {
    	cacheMenu.clear();
	}
    
    /**获取缓存信息*/
    public MenuPojo getMenu(String key) {
        return cacheMenu.get(key);
    }

    /**缓存指定信息*/
    public void putMenu(String key, MenuPojo menu) {
        cacheMenu.put(key, menu);
    }

    /**移除指定缓存信息*/
    public void removeMenu(String key) {
        cacheMenu.remove(key);
    }

    /**清除缓存信息*/
    public void clearMenu() {
        cacheMenu.clear();
    }
    
    //===========================GET/SET=============================
    public static CacheManager getInstance() {
        return instance;
    }


}
