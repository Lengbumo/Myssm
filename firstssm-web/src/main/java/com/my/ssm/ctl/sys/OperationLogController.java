package com.my.ssm.ctl.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.ssm.sys.model.OperationLog;
import com.my.ssm.sys.search.OperationLogSearch;
import com.my.ssm.sys.service.OperationLogService;
import com.my.ssm.core.basic.service.BasicService;
import com.my.ssm.core.controller.BasicController;

 /**
 * 系统操作日志表
 *
 * @com.my.ssm.sys.ctl.OperationLogController.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-05-09 09:43:30
 */
@Controller
@RequestMapping(value = "/myssm/manager/operationlog")
public class OperationLogController extends BasicController<OperationLog, OperationLogSearch> {

	@Autowired
	private transient OperationLogService operationLogService;
	private String purl = "/sys/operationlog";
	
	@Override
	protected BasicService<OperationLog, OperationLogSearch> getPagedService() {
		return operationLogService;
	}
	
	@Override
	protected Class<OperationLogSearch> getSearchBean() {
		return OperationLogSearch.class;
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