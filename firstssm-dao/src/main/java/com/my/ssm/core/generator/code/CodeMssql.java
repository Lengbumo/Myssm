package com.my.ssm.core.generator.code;

/**
 * SQLSERVER工具类执行入口
 * 
 * @ClassName:  CodeMssql   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月9日 下午5:03:50   
 *
 */
public class CodeMssql extends CodeModel {

	String type ; // 类型

	public CodeMssql() {
		this.type = "SQLSERVER";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
