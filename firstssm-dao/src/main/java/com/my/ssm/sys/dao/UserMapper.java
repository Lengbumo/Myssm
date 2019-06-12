package com.my.ssm.sys.dao;

import com.my.ssm.sys.model.User;
import com.my.ssm.sys.search.UserSearch;
import com.my.ssm.core.basic.dao.BasicMapper;

 /**
 * 用户基础表
 *
 * @com.my.ssm.sys.dao.UserMapper.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-18 16:36:18
 */
public interface UserMapper extends BasicMapper<User, UserSearch> {

}