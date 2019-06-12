package com.my.ssm.core.generator.code;

/**
 * MYSQL工具类执行入口
 * 
 * @ClassName:  CodeMysql   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月9日 下午5:03:50   
 *
 */
public class CodeMysql extends CodeModel {

	String type ; // 类型

	public CodeMysql() {
		this.type = "MYSQL";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
