package com.my.ssm.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ssm.base.dao.CustomerClassMapper;
import com.my.ssm.base.model.CustomerClass;
import com.my.ssm.base.search.CustomerClassSearch;
import com.my.ssm.base.service.CustomerClassService;
import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.core.basic.service.impl.BasicServiceImpl;

 /**
 * 客户大类基础表
 *
 * @com.my.ssm.base.service.impl.CustomerClassServiceImpl.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-18 10:51:27
 */
@Service
public class CustomerClassServiceImpl extends BasicServiceImpl<CustomerClass, CustomerClassSearch> implements CustomerClassService {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CustomerClassMapper customerClassMapper;
	
	@Override
    protected BasicMapper<CustomerClass, CustomerClassSearch> getBasicMapper() {
        return customerClassMapper;
    }

}