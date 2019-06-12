package com.my.ssm.generator;

import com.my.ssm.core.generator.CodeGenerator;
import com.my.ssm.core.generator.code.CodeMysql;

public class GeneratorMysqlCode {

	public static void main(String[] args) {
		CodeMysql mysql = new CodeMysql();
		mysql.setTableName("SYS_OPERATION_LOG");
		mysql.setBasePackage("com.my.ssm.sys");
		mysql.setModelName("OperationLog");
		mysql.setDescr("系统日志表");
		mysql.setCreateJsp(true);
		// mysql.setPrtChildTableStyle(false); 
		
		CodeGenerator.generatorMysqlCode(mysql);
	}
}
