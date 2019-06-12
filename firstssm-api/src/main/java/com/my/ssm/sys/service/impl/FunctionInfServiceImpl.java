package com.my.ssm.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ssm.sys.model.FunctionInf;
import com.my.ssm.sys.search.FunctionInfSearch;
import com.my.ssm.sys.dao.FunctionInfMapper;
import com.my.ssm.sys.service.FunctionInfService;
import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.core.basic.service.impl.BasicServiceImpl;

 /**
 * 系统功能表
 *
 * @com.my.ssm.sys.service.impl.FunctionInfServiceImpl.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-05-09 12:01:03
 */
@Service
public class FunctionInfServiceImpl extends BasicServiceImpl<FunctionInf, FunctionInfSearch> implements FunctionInfService {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FunctionInfMapper functionInfMapper;
	
	@Override
    protected BasicMapper<FunctionInf, FunctionInfSearch> getBasicMapper() {
        return functionInfMapper;
    }

}