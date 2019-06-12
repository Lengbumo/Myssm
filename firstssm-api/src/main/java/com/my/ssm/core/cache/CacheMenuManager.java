package com.my.ssm.core.cache;

import com.my.ssm.core.util.ToolsUtil;
import com.my.ssm.sys.pojo.MenuPojo;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.LFUCache;

/**
 * 按钮缓存操作器
 * 
 * @ClassName  CacheMenuManager        
 * 
 * @author WJ
 * @date   2019年5月15日 上午11:07:49   
 *
 */
public class CacheMenuManager {

	private int CAPACITY = 10; // 默认大小
    private volatile LFUCache<String, MenuPojo> MENUCACHE; // 操作按钮缓存
    
    public CacheMenuManager(int capacity) {
		synchronized (this) {
			init(capacity);
		}
	}

	/**
     * 初始化缓存
     * 
     * @Title init    
     * @param capacity
     * @return          
     *  
     * @author WJ
     * @date   2019年5月15日 上午11:09:58
     */
    private LFUCache<String, MenuPojo> init(int capacity) {
        if (null == MENUCACHE) {
            MENUCACHE = CacheUtil.newLFUCache(capacity);
        }

        return MENUCACHE;
    }

    /**
     * 根据操作Key获取对应的操作信息
     * 
     * @Title get    
     * @param key
     * @return          
     *  
     * @author WJ
     * @date   2019年5月15日 上午11:27:12
     */
	public MenuPojo get(String key) {
		if (ToolsUtil.isNull(key)) {
            return null;
        }
		
		return MENUCACHE.get(key);
	}
	
	/**
	 * 存放菜单或按钮
	 * 
	 * @Title put    
	 * @param key
	 * @param menu          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 上午11:29:18
	 */
	public void put(String key, MenuPojo menu) {
		if (null == MENUCACHE) {
			init(CAPACITY);
		}
		MENUCACHE.put(key, menu);
	}
	
	/**
	 * 移除指定Key的缓存信息
	 * 
	 * @Title remove    
	 * @param key          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 上午11:29:52
	 */
	public void remove(String key) {
        if (null == MENUCACHE) {
            return;
        }

        MENUCACHE.remove(key);
    }
	
	/**
	 * 清空缓存信息
	 * 
	 * @Title clear              
	 *  
	 * @author WJ
	 * @date   2019年5月15日 上午11:30:34
	 */
	public void clear() {
        if (null == MENUCACHE) {
            return;
        }

        MENUCACHE.clear();
    }

}
