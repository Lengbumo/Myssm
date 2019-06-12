package com.my.ssm.sys.model;

import java.util.Date;
import com.my.ssm.core.basic.model.BasicModel;


/**
 * 系统日志表
 *
 * @com.my.ssm.sys.model.OperationLog.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-05-15 16:38:04
 */
public class OperationLog extends BasicModel {

	private static final long serialVersionUID = 1L;

	private String userCode; // 用户编码
	
	private String userName; // 用户名称
	
	private Date operDate; // 操作时间
	
	private String operModuleCode; // 模块编码
	
	private String operModuleDesc; // 模块描述
	
	private String operMenuCode; // 菜单编码
	
	private String operMenuDesc; // 菜单描述
	
	private String operMethod; // 操作描述
	
	private String operDesc; // 操作关键字
	
	private String compareInf; // 操作内容
	
	private String operIp; // IP地址
	
	private String browserType; // 浏览器类型
	
	private String browserVersion; // 浏览器版本
	
	private String resultMsg; // 操作结果
	
	private String udf01; // 备用01
	
	private String udf02; // 备用02
	
	private String udf03; // 备用03
	
	private String udf04; // 备用04
	
	private String udf05; // 备用05
	

	
	/**
     * 设置用户编码 
     *
     * @param desc:用户编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}
	
	/**
     * 获取用户编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getUserCode() {
		return userCode;
	}
			
	/**
     * 设置用户名称 
     *
     * @param desc:用户名称
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}
	
	/**
     * 获取用户名称 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getUserName() {
		return userName;
	}
			
	/**
     * 设置操作时间 
     *
     * @param desc:操作时间
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}
	
	/**
     * 获取操作时间 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public Date getOperDate() {
		return operDate;
	}
			
	/**
     * 设置模块编码 
     *
     * @param desc:模块编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setOperModuleCode(String operModuleCode) {
		this.operModuleCode = operModuleCode == null ? null : operModuleCode.trim();
	}
	
	/**
     * 获取模块编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getOperModuleCode() {
		return operModuleCode;
	}
			
	/**
     * 设置模块描述 
     *
     * @param desc:模块描述
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setOperModuleDesc(String operModuleDesc) {
		this.operModuleDesc = operModuleDesc == null ? null : operModuleDesc.trim();
	}
	
	/**
     * 获取模块描述 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getOperModuleDesc() {
		return operModuleDesc;
	}
			
	/**
     * 设置菜单编码 
     *
     * @param desc:菜单编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setOperMenuCode(String operMenuCode) {
		this.operMenuCode = operMenuCode == null ? null : operMenuCode.trim();
	}
	
	/**
     * 获取菜单编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getOperMenuCode() {
		return operMenuCode;
	}
			
	/**
     * 设置菜单描述 
     *
     * @param desc:菜单描述
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setOperMenuDesc(String operMenuDesc) {
		this.operMenuDesc = operMenuDesc == null ? null : operMenuDesc.trim();
	}
	
	/**
     * 获取菜单描述 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getOperMenuDesc() {
		return operMenuDesc;
	}
			
	/**
     * 设置操作描述 
     *
     * @param desc:操作描述
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setOperMethod(String operMethod) {
		this.operMethod = operMethod == null ? null : operMethod.trim();
	}
	
	/**
     * 获取操作描述 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getOperMethod() {
		return operMethod;
	}
			
	/**
     * 设置操作关键字 
     *
     * @param desc:操作关键字
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setOperDesc(String operDesc) {
		this.operDesc = operDesc == null ? null : operDesc.trim();
	}
	
	/**
     * 获取操作关键字 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getOperDesc() {
		return operDesc;
	}
			
	/**
     * 设置操作内容 
     *
     * @param desc:操作内容
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setCompareInf(String compareInf) {
		this.compareInf = compareInf == null ? null : compareInf.trim();
	}
	
	/**
     * 获取操作内容 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getCompareInf() {
		return compareInf;
	}
			
	/**
     * 设置IP地址 
     *
     * @param desc:IP地址
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setOperIp(String operIp) {
		this.operIp = operIp == null ? null : operIp.trim();
	}
	
	/**
     * 获取IP地址 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getOperIp() {
		return operIp;
	}
			
	/**
     * 设置浏览器类型 
     *
     * @param desc:浏览器类型
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setBrowserType(String browserType) {
		this.browserType = browserType == null ? null : browserType.trim();
	}
	
	/**
     * 获取浏览器类型 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getBrowserType() {
		return browserType;
	}
			
	/**
     * 设置浏览器版本 
     *
     * @param desc:浏览器版本
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion == null ? null : browserVersion.trim();
	}
	
	/**
     * 获取浏览器版本 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getBrowserVersion() {
		return browserVersion;
	}
			
	/**
     * 设置操作结果 
     *
     * @param desc:操作结果
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg == null ? null : resultMsg.trim();
	}
	
	/**
     * 获取操作结果 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-15 16:38:04
     */
	public String getResultMsg() {
		return resultMsg;
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