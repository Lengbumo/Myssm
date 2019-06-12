package com.my.ssm.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ssm.base.dao.CustomerMapper;
import com.my.ssm.base.model.Customer;
import com.my.ssm.base.search.CustomerSearch;
import com.my.ssm.base.service.CustomerService;
import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.core.basic.service.impl.BasicServiceImpl;

 /**
 * 客户管理基础表
 * @com.my.ssm.base.service.impl.CustomerServiceImpl.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-17 16:23:20
 */
@Service
public class CustomerServiceImpl extends BasicServiceImpl<Customer, CustomerSearch> implements CustomerService {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
    protected BasicMapper<Customer, CustomerSearch> getBasicMapper() {
        return customerMapper;
    }

}