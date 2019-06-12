package com.my.ssm.generator;

import com.my.ssm.core.generator.CodeGenerator;
import com.my.ssm.core.generator.code.CodeMssql;

public class GeneratorMssqlCode {

	public static void main(String[] args) {
		CodeMssql mssql = new CodeMssql();
		mssql.setTableName("BASE_CUSTOMER");
		mssql.setBasePackage("com.my.ssm.base");
		mssql.setModelName("Customer");
		mssql.setDescr("客户基础表");
		mssql.setCreateJsp(true);
		// mssql.setPrtChildTableStyle(false);
		
		CodeGenerator.generatorMssqlCode(mssql);
	}
}
