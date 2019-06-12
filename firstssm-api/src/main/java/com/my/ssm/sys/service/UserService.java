package com.my.ssm.sys.service;

import com.my.ssm.sys.model.User;
import com.my.ssm.sys.search.UserSearch;
import com.my.ssm.core.basic.service.BasicService;

 /**
 * 用户基础表
 *
 * @com.my.ssm.sys.service.UserService.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-18 16:36:18
 */
public interface UserService extends BasicService<User, UserSearch> {

	/**
	 * 通过用户编码获取用户信息
	 * 
	 * @Title getByUserCode    
	 * @param userCode
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年4月18日 下午5:35:25
	 */
    User getByUserCode(String userCode);
}