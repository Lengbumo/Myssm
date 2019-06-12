package com.my.ssm.core.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.BeanUtils;

import com.my.ssm.core.generator.code.CodeModel;
import com.my.ssm.core.generator.code.CodeMssql;
import com.my.ssm.core.generator.code.CodeMysql;
import com.my.ssm.core.generator.code.CodeOracle;
import com.my.ssm.core.generator.code.Coloum;
import com.my.ssm.core.generator.code.EntityDataModel;
import com.my.ssm.core.generator.code.HiddenEnum;
import com.my.ssm.core.generator.code.PublicEnum;
import com.my.ssm.core.util.DateUtil;
import com.my.ssm.core.util.PConst;
import com.my.ssm.core.util.PropertyUtil;
import com.my.ssm.core.util.ToolsUtil;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


/**
 * 逆向工程生成代码
 * 
 * @ClassName:  CodeGenerator   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月9日 下午4:58:34   
 *
 */
public class CodeGenerator {
	
	/**
	 * sqlserver 生成代码
	 * 
	 * @Title: generatorMssqlCode    
	 * @Desc:  需要build.properties文件
	 * @param: mssql 
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月9日 下午5:31:00
	 */
	public static void generatorMssqlCode(CodeMssql mssql) {
		// 获取配置文件 
		Properties resource = PropertyUtil.init("build.properties");
		String driver = resource.getProperty("generator.jdbcDriver");
		String url = resource.getProperty("generator.jdbcUrl");
		String user = resource.getProperty("generator.username");
		String pwd = resource.getProperty("generator.password");
		
		// 获取databaseName
		String databaseName = url.toUpperCase().split(";")[1];
		databaseName = databaseName.split("=")[1];
		
		// 为mssql实体赋值 
		mssql.setDatabaseName(databaseName);
		mssql.setDriverClassName(driver);
		mssql.setUrl(url);
		mssql.setUsername(user);
		mssql.setPassword(pwd);
		
		// 生成代码
		generatorCode(mssql);
        
	}
	
	/**
	 * mysql 生成代码
	 * 
	 * @Title: generatorMysqlCode    
	 * @Desc:  需要build.properties文件
	 * @param: mysql      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月10日 上午11:05:10
	 */
	public static void generatorMysqlCode(CodeMysql mysql) {
		// 获取配置文件
		Properties resource = PropertyUtil.init("build.properties");
		String driver = resource.getProperty("generator.jdbcDriver");
		String url = resource.getProperty("generator.jdbcUrl");
		String user = resource.getProperty("generator.username");
		String pwd = resource.getProperty("generator.password");
		
		// 获取databaseName
		String databaseName = url.substring(url.lastIndexOf("/") + 1);
		
		// 为mssql实体赋值 
		mysql.setDatabaseName(databaseName);
		mysql.setDriverClassName(driver);
		mysql.setUrl(url);
		mysql.setUsername(user);
		mysql.setPassword(pwd);
		
		// 生成代码
		generatorCode(mysql);
	}
	
	/**
	 * oracle 生成代码
	 * 
	 * @Title generatorOracleCode
	 * @Desc:  需要build.properties文件    
	 * @param oracle          
	 *  
	 * @author WJ
	 * @date   2019年4月17日 下午12:07:50
	 */
	public static void generatorOracleCode(CodeOracle oracle) {
		// 获取配置文件
		Properties resource = PropertyUtil.init("build.properties");
		String driver = resource.getProperty("generator.jdbcDriver");
		String url = resource.getProperty("generator.jdbcUrl");
		String user = resource.getProperty("generator.username");
		String pwd = resource.getProperty("generator.password");
		
		// 获取databaseName
		String databaseName = url.substring(url.lastIndexOf(":") + 1);
		
		// 为mssql实体赋值 
		oracle.setDatabaseName(databaseName);
		oracle.setDriverClassName(driver);
		oracle.setUrl(url);
		oracle.setUsername(user);
		oracle.setPassword(pwd);
		
		// 生成代码
		generatorCode(oracle);
	}
	
	/**
	 * 生成代码
	 * 
	 * @Title: generatorCode    
	 * @Desc:  
	 * @param: @param codeModel      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月17日 上午11:02:57
	 */
	private static void generatorCode(CodeModel codeModel) {
		Connection con = null;
        // 注册驱动
        try {
            Class.forName(codeModel.getDriverClassName());
            con = DriverManager.getConnection(codeModel.getUrl(), codeModel.getUsername(), codeModel.getPassword());
        } catch (Exception e) {
        	System.out.println(String.format("数据库连接失败 %s", e.getMessage()));
            return;
        }
		
        try {
        	System.out.println("--------------> 创建开始");
        	
            // 获取实体类属性
            EntityDataModel entityModel = getEntityModel(con, codeModel);
            
            // 创建model
            entityModel.setModelName("model");
            generateCode(entityModel,  "Model.ftl");
            
            // 创建DTO
            EntityDataModel dtoEntityModel = new EntityDataModel();
            BeanUtils.copyProperties(entityModel, dtoEntityModel);
            dtoEntityModel.setModelName("dto");
            dtoEntityModel.setEntityName(dtoEntityModel.getEntityName() + "DTO");
            generateCode(dtoEntityModel,  "DTO.ftl");
            
            // 创建pojo
            EntityDataModel pojoEntityModel = new EntityDataModel();
            BeanUtils.copyProperties(entityModel, pojoEntityModel);
            pojoEntityModel.setModelName("pojo");
            pojoEntityModel.setEntityName(pojoEntityModel.getEntityName() + "Pojo");
            generateCode(pojoEntityModel,  "Pojo.ftl");
            
            // 创建search
            EntityDataModel searchEntityModel = new EntityDataModel();
            BeanUtils.copyProperties(entityModel, searchEntityModel);
            searchEntityModel.setModelName("search");
            searchEntityModel.setEntityName(searchEntityModel.getEntityName() + "Search");
            generateCode(searchEntityModel,  "Search.ftl");
            
            // 创建dao
            EntityDataModel daoEntityModel = new EntityDataModel();
            BeanUtils.copyProperties(entityModel, daoEntityModel);
            daoEntityModel.setModelName("dao");
            daoEntityModel.setEntityName(daoEntityModel.getEntityName() + "Mapper");
            generateCode(daoEntityModel,  "DaoMapper.ftl");
            
            // 创建mapperxml
            EntityDataModel xmlEntityModel = new EntityDataModel();
            BeanUtils.copyProperties(entityModel, xmlEntityModel);
            xmlEntityModel.setModelName("custom");
            xmlEntityModel.setEntityName(xmlEntityModel.getEntityName() + "Mapper");
            xmlEntityModel.setFileSuffix(".xml");
            generateCode(xmlEntityModel,  "CustomXml.ftl");
            
            // 创建service
            EntityDataModel serviceEntityModel = new EntityDataModel();
            BeanUtils.copyProperties(entityModel, serviceEntityModel);
            serviceEntityModel.setModelName("service");
            serviceEntityModel.setEntityName(serviceEntityModel.getEntityName() + "Service");
            generateCode(serviceEntityModel,  "Service.ftl");
            
            // 创建serviceImpl
            EntityDataModel serviceImplEntityModel = new EntityDataModel();
            BeanUtils.copyProperties(entityModel, serviceImplEntityModel);
            serviceImplEntityModel.setModelName("service.impl");
            serviceImplEntityModel.setEntityName(serviceImplEntityModel.getEntityName() + "ServiceImpl");
            generateCode(serviceImplEntityModel,  "ServiceImpl.ftl");
            
            // 创建controller
            EntityDataModel controllerEntityModel = new EntityDataModel();
            BeanUtils.copyProperties(entityModel, controllerEntityModel);
            String packageName = controllerEntityModel.getEntityPackage();
            String newPackageName = "";
            String[] split = packageName.split("\\.");
            for (int i = 0; i< split.length; i++) {
            	if (i == split.length -1) {
            		newPackageName += "ctl." + split[i];
            		break;
            	}
            	newPackageName += split[i] + ".";
            }
            controllerEntityModel.setBelongPackage(controllerEntityModel.getEntityPackage().substring(controllerEntityModel.getEntityPackage().lastIndexOf(PConst.SPOT) + 1));
            controllerEntityModel.setCtlPackage(newPackageName);
            controllerEntityModel.setModelName("ctl");
            controllerEntityModel.setEntityName(controllerEntityModel.getEntityName() + "Controller");
            generateCode(controllerEntityModel,  "Controller.ftl");
            
            // 创建jsp
            if (codeModel.isCreateJsp()) {
            	if (codeModel.isPrtChildTableStyle()) {
            		
            	} else {
            		// list.jsp
                	EntityDataModel listJspEntityModel = new EntityDataModel();
                    BeanUtils.copyProperties(entityModel, listJspEntityModel);
                    listJspEntityModel.setJspPackage(listJspEntityModel.getEntityPackage().substring(listJspEntityModel.getEntityPackage().lastIndexOf(PConst.SPOT) + 1));
                    listJspEntityModel.setModelName("views/" + listJspEntityModel.getJspPackage() + "/" +listJspEntityModel.getEntityName().toLowerCase());
                    listJspEntityModel.setFileSuffix(".jsp");
                    listJspEntityModel.setEntityName("list");
                    generateCode(listJspEntityModel,  "ListJsp.ftl");
                    
                    // list.js
                    EntityDataModel listJsEntityModel = new EntityDataModel();
                    BeanUtils.copyProperties(entityModel, listJsEntityModel);
                    listJsEntityModel.setJspPackage(listJsEntityModel.getEntityPackage().substring(listJsEntityModel.getEntityPackage().lastIndexOf(PConst.SPOT) + 1));
                    listJsEntityModel.setModelName("static/loc/js/" + listJsEntityModel.getJspPackage() + "/" +listJsEntityModel.getEntityName().toLowerCase());
                    listJsEntityModel.setFileSuffix(".js");
                    listJsEntityModel.setEntityName("list");
                    generateCode(listJsEntityModel,  "ListJs.ftl");
                    
                    // form.jsp
                	EntityDataModel formJspEntityModel = new EntityDataModel();
                    BeanUtils.copyProperties(listJspEntityModel, formJspEntityModel);
                    listJspEntityModel.setEntityName("form");
                    generateCode(listJspEntityModel,  "FormJsp.ftl");
                    
                    // form.js
                    EntityDataModel formJsEntityModel = new EntityDataModel();
                    BeanUtils.copyProperties(listJsEntityModel, formJsEntityModel);
                    listJsEntityModel.setEntityName("form");
                    generateCode(listJsEntityModel,  "FormJs.ftl");
                    
                    // view.jsp
                	EntityDataModel viewJspEntityModel = new EntityDataModel();
                    BeanUtils.copyProperties(listJspEntityModel, viewJspEntityModel);
                    listJspEntityModel.setEntityName("view");
                    generateCode(listJspEntityModel,  "ViewJsp.ftl");
                    
                    // view.js
                    EntityDataModel viewJsEntityModel = new EntityDataModel();
                    BeanUtils.copyProperties(listJsEntityModel, viewJsEntityModel);
                    listJsEntityModel.setEntityName("view");
                    generateCode(listJsEntityModel,  "ViewJs.ftl");
            	}
            }
            
            System.out.println("--------------> 创建结束");
            
        } catch (Exception e) {
        	System.out.println(String.format("代码生成出错  %s", e.getMessage()));
        }
	}
	
	/**
	 * 生成实体
	 * 
	 * @Title: generateCode    
	 * @Desc:  
	 * @param: @param dataModel
	 * @param: @param templateName
	 * @param: @param codeModel
	 * @param: @throws IOException
	 * @param: @throws TemplateException      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月15日 下午5:47:36
	 */
	private static void generateCode(EntityDataModel dataModel, String templateName)
            throws IOException, TemplateException {
		// 获取当前项目路径
        String path = CodeGenerator.class.getResource("/").getPath();
        path = StrUtil.sub(path, 1, path.indexOf("/target"));
        // 获取模板路径
        String templatePath = path + "/src/test/resources/templates/init-code-template";
        // 根据实体包名创建目录
        String entityDir = path + "/target/generator-code/" + dataModel.getEntityPackage().replaceAll("\\.", "/") + "/" + dataModel.getModelName().replaceAll("\\.", "/");
        if (!FileUtil.exist(entityDir)) {
        	FileUtil.mkdir(entityDir);
        	System.out.println(String.format("--------------> 创建目录%s",entityDir.substring(entityDir.indexOf("generator-code/"))));
        }
        String file = entityDir +"/"+ dataModel.getEntityName() + dataModel.getFileSuffix();
        //获取模板对象
        Configuration conf = new Configuration();
        File temp = new File(templatePath);
        conf.setDirectoryForTemplateLoading(temp);
        Template template = conf.getTemplate(templateName);
        Writer writer = new FileWriter(file);
        //填充数据模型
        template.process(dataModel, writer);
        writer.close();
        System.out.println(String.format("--------------> 创建实体%s", dataModel.getEntityName() + dataModel.getFileSuffix()));
        
	}

	/**
	 * 格式化生成实体所需属性
	 * 
	 * @Title: getEntityModel    
	 * @Desc:  
	 * @param: @param con
	 * @param: @param codeModel
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: EntityDataModel      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月15日 下午5:21:20
	 */
	private static EntityDataModel getEntityModel(Connection con, Object codeModel) throws Exception{
		String sql = getSqlByModelType(codeModel);
		ResultSet rs = null;
		CodeModel model = (CodeModel) codeModel;
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println(sql);
	        rs = ps.executeQuery();
			
	        EntityDataModel dataModel = new EntityDataModel();
	        List<Coloum> columns = new ArrayList<>();
	        boolean flag = false;
	        boolean dateFlag = false;
	        while (rs.next()) {
	        	Coloum col = new Coloum();
	        	boolean stringFlag = false;
	            String filedName = rs.getString("column_name");
	            String type = rs.getString("column_type").toLowerCase();
	            String comment = rs.getString("column_comment");
	            String jdbcType = "";
	            String name = "";
	            
	            if (type.contains("varchar") || type.contains("nvarchar")) {
	            	stringFlag = true;
	            	type = "String";
	                jdbcType = "VARCHAR";
	            } else if (type.contains("datetime") || type.contains("timestamp") || type.contains("time")) {
	            	if (!PublicEnum.isInclude(filedName.toUpperCase())) {
	            		dateFlag = true;
	            	}
	            	type = "Date";
	                jdbcType = "TIMESTAMP";
	                col.setDateFlag(true);
	            } else if (type.contains("decimal")) {
	            	flag = true;
	            	type = "BigDecimal";
	            	jdbcType = "DECIMAL";
	            	col.setBigdecimalFlag(true);
	            } else if (type.contains("bigint") || type.contains("int")) {
	            	type = "Long";
	            	jdbcType = "DECIMAL";
	            } else {
	            	stringFlag = true;
	                type = "String";
	                jdbcType = "VARCHAR";
	            }
	            
	            col.setFiledName(filedName.toUpperCase());
	            // 先将字段转成小写,再转驼峰
	            name = StrUtil.toCamelCase(filedName.toLowerCase());
	            col.setName(name);
	            col.setType(type);
	            col.setComment(comment);
	            col.setJdbcType(jdbcType);
	            col.setStringFlag(stringFlag);
	            col.setMethodName(ToolsUtil.toUpperCaseFirstOne(name));
	            // 是否隐藏字段
	            if (HiddenEnum.isInclude(filedName.toUpperCase())) {
	            	col.setHiddenFlag(true);
	            }
	            // 是否是公共字段
	            if (PublicEnum.isInclude(filedName.toUpperCase())) {
	            	col.setPublicFlag(true);
	            }
	            
	            columns.add(col);
	        }
	        
	        dataModel.setBigDecimalFlag(flag);
	        dataModel.setDateFlag(dateFlag);
	        dataModel.setDescr(model.getDescr());
	        dataModel.setEntityPackage(model.getBasePackage());
	        dataModel.setEntityName(model.getModelName());
	        dataModel.setBaseName(model.getModelName());
	        dataModel.setCreateTime(DateUtil.getTime());
	        dataModel.setColumns(columns);
	        dataModel.setTableName(model.getTableName());
	        dataModel.setLowerBaseName(ToolsUtil.toLowerCaseFirstOne(model.getModelName()));
	        
			return dataModel;
		} catch (Exception e) {
			System.out.println("实体数据获取失败");
			throw new Exception(e);
		} finally {
			// 关闭数据库
			if (con != null) {
				try {
					if (rs != null) {
						rs.close();
					}
					con.close();
				} catch (SQLException e) {
					rs = null;
					con = null;
				}
			}
		}
	}
	
	/**
	 * 根据不同数据库获取不同sql查询语句
	 * 
	 * @Title: getSql    
	 * @Desc:  
	 * @param: @param codeModel
	 * @param: @return      
	 * @return: String      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月17日 上午10:51:59
	 */
	private static String getSqlByModelType(Object codeModel) {
		String sql = "";
		CodeModel model = (CodeModel) codeModel;
		// 查询表属性,格式化生成实体所需属性
		if (codeModel instanceof CodeMssql) {
            sql = String.format("use %s SELECT CONVERT(nvarchar(80),a.NAME) column_name,"
            		+ "CONVERT(nvarchar(80),b.NAME) column_type,"
            		+ "CONVERT(nvarchar(80),isnull(g.[VALUE],'')) column_comment "
            		+ "FROM [dbo].syscolumns a "
            		+ "LEFT JOIN [dbo].systypes b ON a.xusertype=b.xusertype "
            		+ "INNER JOIN [dbo].sysobjects d ON a.id=d.id AND d.xtype='U' AND d.NAME <> 'dtproperties' "
            		+ "LEFT JOIN sys.extended_properties g ON a.id=G.major_id AND a.colid=g.minor_id WHERE d.NAME= '%s'", model.getDatabaseName(), model.getTableName());
            
		} else if (codeModel instanceof CodeMysql) {
			sql = String.format("SELECT column_name,column_type,column_comment "
					+ "FROM INFORMATION_SCHEMA.Columns WHERE table_schema='%s' AND table_name='%s' ",
					model.getDatabaseName(), model.getTableName());
		} else if (codeModel instanceof CodeOracle) {
			// oracle查询语句表名需大写
			sql = String.format("use %s SELECT ut.COLUMN_NAME column_name,"
					+ "ut.DATA_TYPE column_type,"
					+ "uc.comments column_comment "
					+ "FROM user_tab_columns ut "
					+ "INNER JOIN user_col_comments uc ON ut.TABLE_NAME=uc.table_name AND ut.COLUMN_NAME=uc.column_name "
					+ "WHERE ut.Table_Name='%s' ", model.getDatabaseName().toUpperCase(), model.getTableName().toUpperCase());
		}
		
		return sql;
	}
	
	// mysql
	// String sql = String.format("select table_name from information_schema.tables where table_schema= %s ", mssql.getDatabaseName());
	
	/*public static void main(String[] args) {
		CodeMssql mssql = new CodeMssql();
		mssql.setTableName("BASE_UNIT");
		mssql.setBasePackage("com.my.ssm.base");
		mssql.setModelName("Unit");
		mssql.setDescr("单位基础表");
		
		generatorMssqlCode(mssql);
	}*/
}
