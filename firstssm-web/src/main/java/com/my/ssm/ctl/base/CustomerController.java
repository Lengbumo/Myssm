package com.my.ssm.ctl.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.ssm.base.model.Customer;
import com.my.ssm.base.search.CustomerSearch;
import com.my.ssm.base.service.CustomerService;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.controller.BasicController;

 /**
 * 客户管理基础表
 *
 * @com.my.ssm.base.ctl.CustomerController.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-17 17:55:00
 */
@Controller
@RequestMapping(value = "/myssm/manager/customer")
public class CustomerController extends BasicController<Customer, CustomerSearch> {

	@Autowired
	private transient CustomerService customerService;
	private String purl = "/base/customer";
	
	@Override
	protected BasicService<Customer, CustomerSearch> getPagedService() {
		return customerService;
	}
	
	@Override
	protected Class<CustomerSearch> getSearchBean() {
		return CustomerSearch.class;
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