package com.my.ssm.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ssm.core.basic.dao.BasicMapper;
import com.my.ssm.core.basic.service.impl.BasicServiceImpl;
import com.my.ssm.core.util.DateUtil;
import com.my.ssm.core.util.PConst;
import com.my.ssm.sec.model.BrowserModel;
import com.my.ssm.sec.util.MiscUtil;
import com.my.ssm.sys.dao.OperationLogMapper;
import com.my.ssm.sys.model.OperationLog;
import com.my.ssm.sys.model.User;
import com.my.ssm.sys.search.OperationLogSearch;
import com.my.ssm.sys.service.OperationLogService;

 /**
 * 系统日志表
 *
 * @com.my.ssm.sys.service.impl.OperationLogServiceImpl.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-05-15 12:34:53
 */
@Service
public class OperationLogServiceImpl extends BasicServiceImpl<OperationLog, OperationLogSearch> implements OperationLogService {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private OperationLogMapper operationLogMapper;
	
	@Override
    protected BasicMapper<OperationLog, OperationLogSearch> getBasicMapper() {
        return operationLogMapper;
    }

	@Override
	public void execLogIn(User user, BrowserModel browser) {
		OperationLog opLog = new OperationLog();
    	opLog.setOperModuleCode(PConst.MODULE_CODE_LOGIN);
    	opLog.setOperMenuCode(PConst.MENU_CODE_LOGIN);
		opLog.setOperMenuDesc(PConst.MENU_NAME_LOGIN);
		// 请求地址
		opLog.setOperDesc(browser.getUrl());
		opLog.setOperIp(browser.getIp());
		opLog.setOperDate(DateUtil.getNow());
		opLog.setBrowserType(browser.getBroType());
		opLog.setBrowserVersion(browser.getBroversion());
		opLog.setUserCode(user.getUserCode());
		opLog.setUserName(user.getUserName());
		opLog.setOperMethod("【用户登录】");
		operationLogMapper.insertSelective(opLog);
		
	}

	@Override
	public void execLogOut() {
		OperationLog opLog = new OperationLog();
		BrowserModel browser = MiscUtil.getBrowser();
    	opLog.setOperModuleCode(PConst.MODULE_CODE_LOGIN_OUT);
    	opLog.setOperMenuCode(PConst.MENU_CODE_LOGIN_OUT);
		opLog.setOperMenuDesc(PConst.MENU_NAME_LOGIN_OUT);
		// 请求地址
		opLog.setOperDesc(browser.getUrl());
		opLog.setOperIp(browser.getIp());
		opLog.setOperDate(DateUtil.getNow());
		opLog.setBrowserType(browser.getBroType());
		opLog.setBrowserVersion(browser.getBroversion());
		opLog.setUserCode(MiscUtil.getUserCode());
		opLog.setUserName(MiscUtil.getUserNameZ());
		opLog.setOperMethod("【用户登出】");
		operationLogMapper.insertSelective(opLog);
	}

}