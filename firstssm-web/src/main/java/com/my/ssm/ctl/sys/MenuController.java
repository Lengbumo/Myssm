package com.my.ssm.ctl.sys;

import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.controller.BasicController;
import com.my.ssm.core.exception.BizException;
import com.my.ssm.core.util.AppRespUtil;
import com.my.ssm.sys.dto.MenuDTO;
import com.my.ssm.sys.model.Menu;
import com.my.ssm.sys.search.MenuSearch;
import com.my.ssm.sys.service.MenuService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

 /**
 * 系统菜单表
 *
 * @com.my.ssm.sys.ctl.MenuController.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-30 10:14:36
 */
@Controller
@RequestMapping(value = "/myssm/manager/menu")
@Api(tags = "菜单接口",description="菜单接口文档说明",hidden=true)
public class MenuController extends BasicController<Menu, MenuSearch> {

	@Autowired
	private transient MenuService menuService;
	private String purl = "/sys/menu";
	
	@Override
	protected BasicService<Menu, MenuSearch> getPagedService() {
		return menuService;
	}
	
	@Override
	protected Class<MenuSearch> getSearchBean() {
		return MenuSearch.class;
	}
	
	@Override
	protected String getReqUrl() {
		return "" + purl;
	}
	
	@Override
	protected String getInitPageName() {
		return purl + "/list";
	}
	
	@Override
	protected String getInitFormName() {
		return purl + "/form";
	}
	
	@Override
	protected String getInitViewName() {
		return purl + "/view";
	}

	/** 保存*/
    @RequestMapping(value = "saveData", method = {RequestMethod.POST})
    @ResponseBody
	@ApiOperation(value="保存菜单按钮",notes="保存菜单接口说明")
	@ApiResponse(response=Menu.class, code = 200, message = "接口返回对象参数")
	public AppRespUtil saveData(Menu record, HttpServletRequest request) {
    	String contxPath = request.getContextPath();
    	record.setSysUrl(contxPath);
    	if (record.getMenuUrl().indexOf("/") != 0) {
    		record.setMenuUrl("/" + record.getMenuUrl());
		}
		return super.save(record);
	}
    
    /**
     * 获取左侧菜单栏
     * 
     * @Title listMenu    
     * @param record
     * @param request
     * @return          
     *  
     * @author WJ
     * @date   2019年5月8日 上午10:37:54
     */
	@ApiOperation(value="取左侧菜单栏",notes="取左侧菜单栏接口说明")
	@ApiResponse(response=Menu.class, code = 200, message = "接口返回对象参数")
    @RequestMapping(value = "listBodyTab", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public AppRespUtil listBodyTab(Menu record, HttpServletRequest request) {
    	Map<String, List<MenuDTO>> tabMenu = null;
    	try {
    		tabMenu = menuService.listBodyTabMenu();
		} catch (BizException e) {
			logger.error("MenuController--> listBodyTabMenu", e.getMessage());
			return AppRespUtil.fail(e.getErrCode() , e.getMessage());
		} catch (Exception e) {
			logger.error("MenuController--> listBodyTabMenu", e.getMessage());
			return AppRespUtil.fail("E0000001" , e.getMessage());
		}
		return AppRespUtil.ok(tabMenu);
	}

}