package com.my.ssm.core.generator.code;

import java.io.Serializable;

/**
 * 代码生成列实体
 * 
 * @ClassName:  Coloum   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月17日 上午10:52:52   
 *
 */
public class Coloum implements Serializable{

	private static final long serialVersionUID = 5295425297692321703L;

	/**
     * 属性注解
     */
    private String annotation;

    /**
     * 属性名
     */
    private String name;
    
    /**
     * 字段值
     */
    private String filedName;

    /**
     * 属性类型
     */
    private String type;

    /**
     * 属性注释
     */
    private String comment;
    
    /**
     * 方法名
     */
    private String methodName;
    
    /**
     * 原属性类型
     */
    private String jdbcType;
    
    /**
     * 是否是String类型
     */
    private boolean stringFlag = false;
    
    /**
     * 是否是数字类型
     */
    private boolean bigdecimalFlag = false;
    
    /**
     * 是否是日期类型
     */
    private boolean dateFlag = false;
    
    /**
     * 备注
     */
    private String mark;
    
    /**
     * 字段是否隐藏 
     */
    private boolean hiddenFlag = false; 
    
    /**
     * 是否是公共字段
     */
    private boolean publicFlag = false; 

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public boolean isStringFlag() {
		return stringFlag;
	}

	public void setStringFlag(boolean stringFlag) {
		this.stringFlag = stringFlag;
	}

	public boolean isBigdecimalFlag() {
		return bigdecimalFlag;
	}

	public void setBigdecimalFlag(boolean bigdecimalFlag) {
		this.bigdecimalFlag = bigdecimalFlag;
	}

	public boolean isDateFlag() {
		return dateFlag;
	}

	public void setDateFlag(boolean dateFlag) {
		this.dateFlag = dateFlag;
	}

	public String getFiledName() {
		return filedName;
	}

	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public boolean isHiddenFlag() {
		return hiddenFlag;
	}

	public void setHiddenFlag(boolean hiddenFlag) {
		this.hiddenFlag = hiddenFlag;
	}

	public boolean isPublicFlag() {
		return publicFlag;
	}

	public void setPublicFlag(boolean publicFlag) {
		this.publicFlag = publicFlag;
	}

}
