package com.my.ssm.sys.dao;

import java.util.List;

import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.sys.model.Menu;
import com.my.ssm.sys.pojo.MenuPojo;
import com.my.ssm.sys.search.MenuSearch;

 /**
 * 系统菜单表
 *
 * @com.my.ssm.sys.dao.MenuMapper.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-30 10:14:36
 */
public interface MenuMapper extends BasicMapper<Menu, MenuSearch> {

	/**
	 * 获取模块类型
	 * 
	 * @Title listBaseModule    
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月8日 上午11:02:58
	 */
	List<Menu> listBaseModule();
	
	/**
	 * 获取所有菜单及按钮
	 * 
	 * @Title listMenu    
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 上午10:55:29
	 */
	List<MenuPojo> listMenu();
}