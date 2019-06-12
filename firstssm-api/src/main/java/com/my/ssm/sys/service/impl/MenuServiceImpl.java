package com.my.ssm.sys.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.core.basic.model.ComBox;
import com.my.ssm.core.basic.service.impl.BasicServiceImpl;
import com.my.ssm.core.exception.BizException;
import com.my.ssm.core.util.PConst;
import com.my.ssm.sys.dao.MenuMapper;
import com.my.ssm.sys.dto.MenuDTO;
import com.my.ssm.sys.model.Menu;
import com.my.ssm.sys.pojo.MenuPojo;
import com.my.ssm.sys.search.MenuSearch;
import com.my.ssm.sys.service.MenuService;

 /**
 * 系统菜单表
 *
 * @com.my.ssm.sys.service.impl.MenuServiceImpl.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-30 10:14:36
 */
@Service
public class MenuServiceImpl extends BasicServiceImpl<Menu, MenuSearch> implements MenuService {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
    protected BasicMapper<Menu, MenuSearch> getBasicMapper() {
        return menuMapper;
    }

	@Override
	public List<ComBox> getMenuComboboxVal(MenuSearch search) {
		List<Menu> list = menuMapper.list(search);
    	List<ComBox> comboxList = new ArrayList<ComBox>();
    	for (Menu menu : list) {
    		ComBox combox = new ComBox();
    		combox.setCode(menu.getId().toString());
    		combox.setCodeName(menu.getMenuName());
    		comboxList.add(combox);
		}
		return comboxList;
	}

	@Override
	public Menu findByMenuCode(String Code, boolean flag) {
		MenuSearch search = new MenuSearch();
		search.setMenuCode(Code);
		Menu record = menuMapper.selectByBizKey(search);
		if (flag && null == record) {
			throw new BizException("E10001", "数据不存在");
		}
		return record;
	}

	@Override
	public Map<String, List<MenuDTO>> listBodyTabMenu() {
		Map<String, List<MenuDTO>> map = new LinkedHashMap<String, List<MenuDTO>>();
		List<Menu> moduleList = menuMapper.listBaseModule();
		MenuSearch search = new MenuSearch();
		for (Menu module : moduleList) {
			List<MenuDTO> tabList = new ArrayList<MenuDTO>();
			map.put(module.getModuleCode(), tabList);
		}
		
		for (Map.Entry<String, List<MenuDTO>> entry : map.entrySet()) {
			// 根据模块编码获取模块下的菜单
			search.setModuleCode(entry.getKey());
			search.setIsParent(PConst.DEFALUT_1);
			List<Menu> list = menuMapper.list(search);
			
			// 递归查询下级菜单
			entry.getValue().addAll(findMenu(list));
		}
		
		return map;
	}
	
	/** 递归查询*/
	private List<MenuDTO> findMenu(List<Menu> list) {
		List<MenuDTO> tabList = new ArrayList<MenuDTO>();
		MenuSearch search = new MenuSearch();
		for (Menu menu : list) {
			MenuDTO tab = new MenuDTO();
			tab.setTitle(menu.getMenuName());
			tab.setIcon(menu.getMenuIcon());
			tab.setHref(PConst.APP_CTX_VALUE + menu.getMenuUrl());
			tab.setSpread(false);
			
			search.setModuleCode(menu.getModuleCode());
			search.setParentId(menu.getId());
			List<Menu> childList = menuMapper.list(search);
			if (childList.size() > 0) {
				tab.setChildren(findMenu(childList));
			}
			tabList.add(tab);
		}
		
		return tabList;
	}

	@Override
	public void save(Menu model) {
		// 新增菜单时,默认新增按钮
		if (null == model.getId()) {
			
		}
		
		super.save(model);
	}

	@Override
	public List<MenuPojo> listMenu() {
		return menuMapper.listMenu();
	}

}