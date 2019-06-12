package com.my.ssm.generator;

import com.my.ssm.core.generator.CodeGenerator;
import com.my.ssm.core.generator.code.CodeOracle;

public class GeneratorOracleCode {

	public static void main(String[] args) {
		CodeOracle oracle = new CodeOracle();
		oracle.setTableName("SYS_USER");
		oracle.setBasePackage("com.my.ssm.base");
		oracle.setModelName("User");
		oracle.setDescr("用户基础表");
		oracle.setCreateJsp(true);
		// oracle.setPrtChildTableStyle(false);
		
		CodeGenerator.generatorOracleCode(oracle);
	}
}
