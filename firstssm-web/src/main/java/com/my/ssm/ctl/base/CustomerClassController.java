package com.my.ssm.ctl.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.ssm.base.model.CustomerClass;
import com.my.ssm.base.search.CustomerClassSearch;
import com.my.ssm.base.service.CustomerClassService;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.controller.BasicController;

 /**
 * 客户大类基础表
 *
 * @com.my.ssm.base.ctl.CustomerClassController.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-18 10:51:27
 */
@Controller
@RequestMapping(value = "/myssm/manager/customerclass")
public class CustomerClassController extends BasicController<CustomerClass, CustomerClassSearch> {

	@Autowired
	private transient CustomerClassService customerClassService;
	private String purl = "/base/customerclass";
	
	@Override
	protected BasicService<CustomerClass, CustomerClassSearch> getPagedService() {
		return customerClassService;
	}
	
	@Override
	protected Class<CustomerClassSearch> getSearchBean() {
		return CustomerClassSearch.class;
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