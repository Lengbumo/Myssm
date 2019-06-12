package com.my.ssm.sys.model;


import com.my.ssm.core.basic.model.BasicModel;


/**
 * 系统功能表
 *
 * @com.my.ssm.sys.model.FunctionInf.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-05-09 12:01:03
 */
public class FunctionInf extends BasicModel {

	private static final long serialVersionUID = 1L;

	private String functionCode; // 功能编码
	
	private String functionName; // 功能名称
	
	private String functionUrl; // 功能地址
	
	private String functionSort; // 排序
	
	private String functionIcon; // 功能图标
	
	private Long menuId; // 所属菜单ID
	
	private String udf01; // 备用01
	
	private String udf02; // 备用02
	
	private String udf03; // 备用03
	
	private String udf04; // 备用04
	
	private String udf05; // 备用05
	
	/**
     * 设置功能编码 
     *
     * @param desc:功能编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode == null ? null : functionCode.trim();
	}
	
	/**
     * 获取功能编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public String getFunctionCode() {
		return functionCode;
	}
			
	/**
     * 设置功能名称 
     *
     * @param desc:功能名称
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public void setFunctionName(String functionName) {
		this.functionName = functionName == null ? null : functionName.trim();
	}
	
	/**
     * 获取功能名称 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public String getFunctionName() {
		return functionName;
	}
			
	/**
     * 设置功能地址 
     *
     * @param desc:功能地址
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl == null ? null : functionUrl.trim();
	}
	
	/**
     * 获取功能地址 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public String getFunctionUrl() {
		return functionUrl;
	}
			
	/**
     * 设置排序 
     *
     * @param desc:排序
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public void setFunctionSort(String functionSort) {
		this.functionSort = functionSort == null ? null : functionSort.trim();
	}
	
	/**
     * 获取排序 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public String getFunctionSort() {
		return functionSort;
	}
			
	/**
     * 设置功能图标 
     *
     * @param desc:功能图标
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public void setFunctionIcon(String functionIcon) {
		this.functionIcon = functionIcon == null ? null : functionIcon.trim();
	}
	
	/**
     * 获取功能图标 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public String getFunctionIcon() {
		return functionIcon;
	}
			
	/**
     * 设置所属菜单ID 
     *
     * @param desc:所属菜单ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	
	/**
     * 获取所属菜单ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-09 12:01:03
     */
	public Long getMenuId() {
		return menuId;
	}
	
	/**
     * 设置备用01 
     *
     * @param desc:备用01
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setUdf01(String udf01) {
		this.udf01 = udf01 == null ? null : udf01.trim();
	}
	
	/**
     * 获取备用01 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getUdf01() {
		return udf01;
	}
			
	/**
     * 设置备用02 
     *
     * @param desc:备用02
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setUdf02(String udf02) {
		this.udf02 = udf02 == null ? null : udf02.trim();
	}
	
	/**
     * 获取备用02 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getUdf02() {
		return udf02;
	}
			
	/**
     * 设置备用03 
     *
     * @param desc:备用03
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setUdf03(String udf03) {
		this.udf03 = udf03 == null ? null : udf03.trim();
	}
	
	/**
     * 获取备用03 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getUdf03() {
		return udf03;
	}
			
	/**
     * 设置备用04 
     *
     * @param desc:备用04
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setUdf04(String udf04) {
		this.udf04 = udf04 == null ? null : udf04.trim();
	}
	
	/**
     * 获取备用04 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getUdf04() {
		return udf04;
	}
			
	/**
     * 设置备用05 
     *
     * @param desc:备用05
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setUdf05(String udf05) {
		this.udf05 = udf05 == null ? null : udf05.trim();
	}
	
	/**
     * 获取备用05 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getUdf05() {
		return udf05;
	}
			
}