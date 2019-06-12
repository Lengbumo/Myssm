package com.my.ssm.core.generator.code;

import freemarker.template.Configuration;

/**
 * 代码生成器配置
 * 
 * @ClassName:  CodeModel   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月17日 上午10:53:19   
 *
 */
public class CodeModel {

	/**
     * 数据库驱动
     */
    private String driverClassName;
    /**
     * 数据库URL
     */
    private String url;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库名
     */
    private String databaseName;

    /**
     * 只生成单表，非必须
     */
    private String tableName;

    /**
     * 表前缀，非必须
     */
    private String tablePrefix;

    /**
     * 生成级别 必须
     * 1 仅生成dao层
     * 2 生成service层
     * 3 生成controller层
     */
    private int genenaterLevel;

    /**
     * 基本包名 必须
     */
    private String basePackage;
    
    /**
     * 实体名
     */
    private String modelName; 

    /**
     * mapper接口包名 无则使用基本包名
     */
    private String mapperPackage;

    /**
     * mapper.xml 生成路径 无则使用基本包名
     */
    private String xmlDir;

    /**
     * servcie包名 impl也在此包路径下 无则使用基本包名
     */
    private String servicePackage;

    /**
     * controller包名 无则使用基本包名
     */
    private String controllerPackage;
    
    /**
     * 模板引擎
     */
    private Configuration configuration;
    
    /**
     * 实体注释
     */
    private String descr;
    
    /**
     * 是否需要生成jsp
     */
    private boolean isCreateJsp;
    
    /**
     * 是否需要主子表样式
     */
    private boolean isPrtChildTableStyle = false;
    
    public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}

	public int getGenenaterLevel() {
		return genenaterLevel;
	}

	public void setGenenaterLevel(int genenaterLevel) {
		this.genenaterLevel = genenaterLevel;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getMapperPackage() {
		return mapperPackage;
	}

	public void setMapperPackage(String mapperPackage) {
		this.mapperPackage = mapperPackage;
	}

	public String getXmlDir() {
		return xmlDir;
	}

	public void setXmlDir(String xmlDir) {
		this.xmlDir = xmlDir;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	/** 是否需要生成jsp*/
	public boolean isCreateJsp() {
		return isCreateJsp;
	}

	/** 是否需要生成jsp*/
	public void setCreateJsp(boolean isCreateJsp) {
		this.isCreateJsp = isCreateJsp;
	}

	/** 是否需要主子表样式*/
	public boolean isPrtChildTableStyle() {
		return isPrtChildTableStyle;
	}

	/** 是否需要主子表样式*/
	public void setPrtChildTableStyle(boolean isPrtChildTableStyle) {
		this.isPrtChildTableStyle = isPrtChildTableStyle;
	}

}
