package com.my.ssm.core.generator.code;

import java.util.Date;
import java.util.List;

/**
 * 模板生成属性
 * 
 * @ClassName:  EntityDataModel   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月17日 上午10:52:40   
 *
 */
public class EntityDataModel {

	/**
     * base package
     */
    private String entityPackage;
    
    /**
     * jsp package
     */
    private String jspPackage;
    
    /**
     * controller package
     */
    private String ctlPackage;
    
    /**
     * 从属于什么模块
     */
    private String belongPackage;
    
    /**
     * 文件名后缀
     */
    private String fileSuffix = ".java";

    /**
     * 实体名
     */
    private String entityName;

    /**
     * 作者 默认
     */
    private String author="auto generator";

    /**
     * 创建时间
     */
    private String createTime = new Date().toString();

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段集合
     */
    private List<Coloum> columns;
    
    /**
     * 是否含有bigDecimal
     */
    private boolean bigDecimalFlag = false;
    
    /**
     * 是否含有date
     */
    private boolean dateFlag = false;
    
    /**
     * 实体注释
     */
    private String descr;
    
    /**
     * 所属模块
     */
    private String modelName;
    
    /**
     * 基础实体名
     */
    private String baseName;
    
    /**
     * 基础实体名,首字母小写
     */
    private String lowerBaseName;

	public String getEntityPackage() {
		return entityPackage;
	}

	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}

	/**
	 * 后缀
	 * 
	 * @Title: getFileSuffix    
	 * @Desc:  
	 * @param: @return      
	 * @return: String      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月15日 下午5:49:18
	 */
	public String getFileSuffix() {
		return fileSuffix;
	}

	/**
	 * 后缀
	 * 
	 * @Title: setFileSuffix    
	 * @Desc:  
	 * @param: @param fileSuffix      
	 * @return: void      
	 * @throws 
	 *  
	 * @author: WJ
	 * @date:   2019年4月15日 下午5:49:28
	 */
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isBigDecimalFlag() {
		return bigDecimalFlag;
	}

	public void setBigDecimalFlag(boolean bigDecimalFlag) {
		this.bigDecimalFlag = bigDecimalFlag;
	}

	public boolean isDateFlag() {
		return dateFlag;
	}

	public void setDateFlag(boolean dateFlag) {
		this.dateFlag = dateFlag;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public String getLowerBaseName() {
		return lowerBaseName;
	}

	public void setLowerBaseName(String lowerBaseName) {
		this.lowerBaseName = lowerBaseName;
	}

	public List<Coloum> getColumns() {
		return columns;
	}

	public void setColumns(List<Coloum> columns) {
		this.columns = columns;
	}

	public String getCtlPackage() {
		return ctlPackage;
	}

	public void setCtlPackage(String ctlPackage) {
		this.ctlPackage = ctlPackage;
	}

	public String getJspPackage() {
		return jspPackage;
	}

	public void setJspPackage(String jspPackage) {
		this.jspPackage = jspPackage;
	}

	public String getBelongPackage() {
		return belongPackage;
	}

	public void setBelongPackage(String belongPackage) {
		this.belongPackage = belongPackage;
	}
    
}
