package com.my.ssm.ctl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.ssm.sys.model.User;
import com.my.ssm.sys.search.UserSearch;
import com.my.ssm.sys.service.UserService;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.controller.BasicController;

 /**
 * 用户基础表
 *
 * @com.my.ssm.sys.ctl.UserController.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-18 16:36:18
 */
@Controller
@RequestMapping(value = "/myssm/manager/user")
public class UserController extends BasicController<User, UserSearch> {

	@Autowired
	private transient UserService userService;
	private String purl = "sys/user";
	
	@Override
	protected BasicService<User, UserSearch> getPagedService() {
		return userService;
	}
	
	@Override
	protected Class<UserSearch> getSearchBean() {
		return UserSearch.class;
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