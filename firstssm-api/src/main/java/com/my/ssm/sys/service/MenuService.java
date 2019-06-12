package com.my.ssm.sys.service;

import java.util.List;
import java.util.Map;

import com.my.ssm.core.basic.model.ComBox;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.sys.dto.MenuDTO;
import com.my.ssm.sys.model.Menu;
import com.my.ssm.sys.pojo.MenuPojo;
import com.my.ssm.sys.search.MenuSearch;

 /**
 * 系统菜单表
 *
 * @com.my.ssm.sys.service.MenuService.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-30 10:14:36
 */
public interface MenuService extends BasicService<Menu, MenuSearch> {

	/**
	 * 获取菜单下拉框
	 * 
	 * @Title getMenuComboboxVal    
	 * @param search
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月6日 上午10:04:00
	 */
	List<ComBox> getMenuComboboxVal(MenuSearch search);
	
	/**
	 * 根据菜单编码查询菜单
	 * 
	 * @Title findByMenuCode    
	 * @param Code
	 * @param flag
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月7日 下午4:16:30
	 */
	Menu findByMenuCode(String Code, boolean flag);
	
	/**
	 * 获取左侧菜单栏
	 * 
	 * @Title listBodyTabMenu    
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月8日 上午10:56:59
	 */
	Map<String, List<MenuDTO>> listBodyTabMenu();
	
	/**
	 * 获取所有菜单及按钮
	 * 
	 * @Title listMenuCach    
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 上午10:55:29
	 */
	List<MenuPojo> listMenu();
}