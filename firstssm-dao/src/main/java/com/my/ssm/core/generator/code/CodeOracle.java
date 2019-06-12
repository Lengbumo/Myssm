package com.my.ssm.core.generator.code;

/**
 * ORACLE工具类执行入口
 * 
 * @ClassName:  CodeOracle   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月9日 下午5:03:50   
 *
 */
public class CodeOracle extends CodeModel {

	String type ; // 类型

	public CodeOracle() {
		this.type = "ORACLE";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
