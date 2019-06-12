package com.my.ssm.ctl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.ssm.sys.model.FunctionInf;
import com.my.ssm.sys.search.FunctionInfSearch;
import com.my.ssm.sys.service.FunctionInfService;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.controller.BasicController;

 /**
 * 系统功能表
 *
 * @com.my.ssm.sys.ctl.FunctionInfController.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-05-09 14:13:26
 */
@Controller
@RequestMapping(value = "/myssm/manager/functioninf")
public class FunctionInfController extends BasicController<FunctionInf, FunctionInfSearch> {

	@Autowired
	private transient FunctionInfService functionInfService;
	private String purl = "/sys/functioninf";
	
	@Override
	protected BasicService<FunctionInf, FunctionInfSearch> getPagedService() {
		return functionInfService;
	}
	
	@Override
	protected Class<FunctionInfSearch> getSearchBean() {
		return FunctionInfSearch.class;
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

}