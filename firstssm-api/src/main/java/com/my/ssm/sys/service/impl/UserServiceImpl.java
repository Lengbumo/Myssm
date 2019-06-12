package com.my.ssm.sys.service.impl;

import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.core.basic.service.impl.BasicServiceImpl;
import com.my.ssm.sys.dao.UserMapper;
import com.my.ssm.sys.model.User;
import com.my.ssm.sys.search.UserSearch;
import com.my.ssm.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户基础表
 *
 * @author system
 * @version 1.0.0
 * @com.my.ssm.sys.service.impl.UserServiceImpl.java
 * @create time 2019-04-18 16:36:18
 * @since JDK 1.8
 */
@Service
public class UserServiceImpl extends BasicServiceImpl<User, UserSearch> implements UserService {
    private static final long serialVersionUID = 1L;

    @Autowired
    private UserMapper userMapper;

    @Override
    protected BasicMapper<User, UserSearch> getBasicMapper() {
        return userMapper;
    }

    @Override
    public User getByUserCode(String userCode) {
        UserSearch search = new UserSearch();
        search.setUserCode(userCode);
        return userMapper.selectByBizKey(search);
    }


}