package com.my.ssm.sys.service;

import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.sec.model.BrowserModel;
import com.my.ssm.sys.model.OperationLog;
import com.my.ssm.sys.model.User;
import com.my.ssm.sys.search.OperationLogSearch;

 /**
 * 系统日志表
 *
 * @com.my.ssm.sys.service.OperationLogService.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-05-15 12:34:53
 */
public interface OperationLogService extends BasicService<OperationLog, OperationLogSearch> {

	/**
	 * 插入用户登录日志
	 * 
	 * @Title execLogIn    
	 * @param user
	 * @param browser          
	 *  
	 * @author WJ
	 * @date   2019年5月15日 下午4:28:52
	 */
	void execLogIn(User user, BrowserModel browser);
	
	/**
	 * 插入用户登出日志
	 * 
	 * @Title execLogOut              
	 *  
	 * @author WJ
	 * @date   2019年5月15日 下午4:28:12
	 */
	void execLogOut();
}