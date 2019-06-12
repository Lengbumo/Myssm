package com.my.ssm.base.service;

import com.my.ssm.base.model.Customer;
import com.my.ssm.base.search.CustomerSearch;
import com.my.ssm.core.basic.service.BasicService;

 /**
 * 客户管理基础表
 * @com.my.ssm.base.service.CustomerService.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-17 16:23:20
 */
public interface CustomerService extends BasicService<Customer, CustomerSearch> {

}