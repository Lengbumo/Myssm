package com.my.ssm.sys.pojo;

import com.my.ssm.sys.model.Menu;

/**
 * 系统菜单表
 *
 * @com.my.ssm.sys.pojo.MenuPojo.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-30 10:14:36
 */
public class MenuPojo extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	private String operionCode; // 按钮编码
	
	private String operionName; // 按钮名称

	public String getOperionCode() {
		return operionCode;
	}

	public void setOperionCode(String operionCode) {
		this.operionCode = operionCode;
	}

	/** 按钮名称*/
	public String getOperionName() {
		return operionName;
	}

	/** 按钮名称*/
	public void setOperionName(String operionName) {
		this.operionName = operionName;
	}
	
}