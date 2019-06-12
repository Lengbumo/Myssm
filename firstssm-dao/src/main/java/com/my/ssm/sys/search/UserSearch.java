package com.my.ssm.sys.search;

import java.util.Date;

import com.my.ssm.core.basic.search.BasicSearch;


/**
 * 用户基础表
 *
 * @com.my.ssm.sys.search.UserSearch.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-18 16:36:18
 */
public class UserSearch extends BasicSearch {
	
	private static final long serialVersionUID = 1L;

	private Long id; // 唯一键ID
	
	private Long corpId; // 默认公司ID
	
	private String corp; // 默认公司CODE
	
	private Long orgnId; // 默认机构ID
	
	private String orgn; // 默认机构CODE
	
	private String userCode; // 用户编码
	
	private String userName; // 用户名称
	
	private String userEname; // 英文名称
	
	private String userDescr; // 用户描述
	
	private Long depId; // 部门ID
	
	private String depCode; // 部门CODE
	
	private Long empId; // 员工ID
	
	private String empCode; // 员工CODE
	
	private String tel; // 电话
	
	private String phone; // 手机
	
	private String emial; // 邮箱
	
	private String others; // 其他信息
	
	private String defLanguage; // 默认语言
	
	private String userType; // 用户类型
	
	private String adminFlag; // 管理员标识
	
	private String pcPassword; // PC登录密码
	
	private String rfPassword; // 手持登录密码
	
	private String salt; // 盐
	
	private String afPc; // PC是否激活
	
	private String afApp; // APP是否激活
	
	private String effDate; // 密码有效开始时间
	
	private String endDate; // 密码有效结束时间
	
	private Date pwdModifyDate; // 密码更新日期
	
	private Long pwdCycle; // 密码更新周日
	
	private String pwdRestFlag; // 密码重置标识
	
	private Date lastDate; // 最后一次登录时间
	
	private String faceImg; // 头像
	
	private String udf01; // 备用01
	
	private String udf02; // 备用02
	
	private String udf03; // 备用03
	
	private String udf04; // 备用04
	
	private String udf05; // 备用05
	
	private String rd; // 数据来源
	
	private String activeFlag; // 记录可用标识
	
	private String remark; // 描述
	
	private String createdBy; // 创建人
	
	private Date createdDate; // 创建日期
	
	private String modifiedBy; // 修改人
	
	private Date modifiedDate; // 修改时间
	
	private String saasid; // SAASID
	
	
	/**
     * 设置唯一键ID 
     *
     * @param desc:唯一键ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
     * 获取唯一键ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Long getId() {
		return id;
	}
		
	/**
     * 设置默认公司ID 
     *
     * @param desc:默认公司ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}
	
	/**
     * 获取默认公司ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Long getCorpId() {
		return corpId;
	}
		
	/**
     * 设置默认公司CODE 
     *
     * @param desc:默认公司CODE
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setCorp(String corp) {
		this.corp = corp == null ? null : corp.trim();
	}
	
	/**
     * 获取默认公司CODE 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getCorp() {
		return corp;
	}
		
	/**
     * 设置默认机构ID 
     *
     * @param desc:默认机构ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setOrgnId(Long orgnId) {
		this.orgnId = orgnId;
	}
	
	/**
     * 获取默认机构ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Long getOrgnId() {
		return orgnId;
	}
		
	/**
     * 设置默认机构CODE 
     *
     * @param desc:默认机构CODE
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setOrgn(String orgn) {
		this.orgn = orgn == null ? null : orgn.trim();
	}
	
	/**
     * 获取默认机构CODE 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getOrgn() {
		return orgn;
	}
		
	/**
     * 设置用户编码 
     *
     * @param desc:用户编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}
	
	/**
     * 获取用户编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
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
     * @create time 2019-04-18 16:36:18
     */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}
	
	/**
     * 获取用户名称 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getUserName() {
		return userName;
	}
		
	/**
     * 设置英文名称 
     *
     * @param desc:英文名称
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setUserEname(String userEname) {
		this.userEname = userEname == null ? null : userEname.trim();
	}
	
	/**
     * 获取英文名称 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getUserEname() {
		return userEname;
	}
		
	/**
     * 设置用户描述 
     *
     * @param desc:用户描述
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setUserDescr(String userDescr) {
		this.userDescr = userDescr == null ? null : userDescr.trim();
	}
	
	/**
     * 获取用户描述 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getUserDescr() {
		return userDescr;
	}
		
	/**
     * 设置部门ID 
     *
     * @param desc:部门ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setDepId(Long depId) {
		this.depId = depId;
	}
	
	/**
     * 获取部门ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Long getDepId() {
		return depId;
	}
		
	/**
     * 设置部门CODE 
     *
     * @param desc:部门CODE
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setDepCode(String depCode) {
		this.depCode = depCode == null ? null : depCode.trim();
	}
	
	/**
     * 获取部门CODE 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getDepCode() {
		return depCode;
	}
		
	/**
     * 设置员工ID 
     *
     * @param desc:员工ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	/**
     * 获取员工ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Long getEmpId() {
		return empId;
	}
		
	/**
     * 设置员工CODE 
     *
     * @param desc:员工CODE
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setEmpCode(String empCode) {
		this.empCode = empCode == null ? null : empCode.trim();
	}
	
	/**
     * 获取员工CODE 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getEmpCode() {
		return empCode;
	}
		
	/**
     * 设置电话 
     *
     * @param desc:电话
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}
	
	/**
     * 获取电话 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getTel() {
		return tel;
	}
		
	/**
     * 设置手机 
     *
     * @param desc:手机
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	
	/**
     * 获取手机 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getPhone() {
		return phone;
	}
		
	/**
     * 设置邮箱 
     *
     * @param desc:邮箱
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setEmial(String emial) {
		this.emial = emial == null ? null : emial.trim();
	}
	
	/**
     * 获取邮箱 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getEmial() {
		return emial;
	}
		
	/**
     * 设置其他信息 
     *
     * @param desc:其他信息
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setOthers(String others) {
		this.others = others == null ? null : others.trim();
	}
	
	/**
     * 获取其他信息 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getOthers() {
		return others;
	}
		
	/**
     * 设置默认语言 
     *
     * @param desc:默认语言
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setDefLanguage(String defLanguage) {
		this.defLanguage = defLanguage == null ? null : defLanguage.trim();
	}
	
	/**
     * 获取默认语言 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getDefLanguage() {
		return defLanguage;
	}
		
	/**
     * 设置用户类型 
     *
     * @param desc:用户类型
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setUserType(String userType) {
		this.userType = userType == null ? null : userType.trim();
	}
	
	/**
     * 获取用户类型 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getUserType() {
		return userType;
	}
		
	/**
     * 设置管理员标识 
     *
     * @param desc:管理员标识
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag == null ? null : adminFlag.trim();
	}
	
	/**
     * 获取管理员标识 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getAdminFlag() {
		return adminFlag;
	}
		
	/**
     * 设置PC登录密码 
     *
     * @param desc:PC登录密码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setPcPassword(String pcPassword) {
		this.pcPassword = pcPassword == null ? null : pcPassword.trim();
	}
	
	/**
     * 获取PC登录密码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getPcPassword() {
		return pcPassword;
	}
		
	/**
     * 设置手持登录密码 
     *
     * @param desc:手持登录密码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setRfPassword(String rfPassword) {
		this.rfPassword = rfPassword == null ? null : rfPassword.trim();
	}
	
	/**
     * 获取手持登录密码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getRfPassword() {
		return rfPassword;
	}
		
	/**
     * 设置盐 
     *
     * @param desc:盐
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}
	
	/**
     * 获取盐 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getSalt() {
		return salt;
	}
		
	/**
     * 设置PC是否激活 
     *
     * @param desc:PC是否激活
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setAfPc(String afPc) {
		this.afPc = afPc == null ? null : afPc.trim();
	}
	
	/**
     * 获取PC是否激活 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getAfPc() {
		return afPc;
	}
		
	/**
     * 设置APP是否激活 
     *
     * @param desc:APP是否激活
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setAfApp(String afApp) {
		this.afApp = afApp == null ? null : afApp.trim();
	}
	
	/**
     * 获取APP是否激活 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getAfApp() {
		return afApp;
	}
		
	/**
     * 设置密码有效开始时间 
     *
     * @param desc:密码有效开始时间
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setEffDate(String effDate) {
		this.effDate = effDate == null ? null : effDate.trim();
	}
	
	/**
     * 获取密码有效开始时间 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getEffDate() {
		return effDate;
	}
		
	/**
     * 设置密码有效结束时间 
     *
     * @param desc:密码有效结束时间
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}
	
	/**
     * 获取密码有效结束时间 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getEndDate() {
		return endDate;
	}
		
	/**
     * 设置密码更新日期 
     *
     * @param desc:密码更新日期
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setPwdModifyDate(Date pwdModifyDate) {
		this.pwdModifyDate = pwdModifyDate;
	}
	
	/**
     * 获取密码更新日期 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Date getPwdModifyDate() {
		return pwdModifyDate;
	}
		
	/**
     * 设置密码更新周日 
     *
     * @param desc:密码更新周日
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setPwdCycle(Long pwdCycle) {
		this.pwdCycle = pwdCycle;
	}
	
	/**
     * 获取密码更新周日 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Long getPwdCycle() {
		return pwdCycle;
	}
		
	/**
     * 设置密码重置标识 
     *
     * @param desc:密码重置标识
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setPwdRestFlag(String pwdRestFlag) {
		this.pwdRestFlag = pwdRestFlag == null ? null : pwdRestFlag.trim();
	}
	
	/**
     * 获取密码重置标识 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getPwdRestFlag() {
		return pwdRestFlag;
	}
		
	/**
     * 设置最后一次登录时间 
     *
     * @param desc:最后一次登录时间
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	
	/**
     * 获取最后一次登录时间 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Date getLastDate() {
		return lastDate;
	}
		
	/**
     * 设置头像 
     *
     * @param desc:头像
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg == null ? null : faceImg.trim();
	}
	
	/**
     * 获取头像 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getFaceImg() {
		return faceImg;
	}
		
	/**
     * 设置备用01 
     *
     * @param desc:备用01
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setUdf01(String udf01) {
		this.udf01 = udf01 == null ? null : udf01.trim();
	}
	
	/**
     * 获取备用01 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
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
     * @create time 2019-04-18 16:36:18
     */
	public void setUdf02(String udf02) {
		this.udf02 = udf02 == null ? null : udf02.trim();
	}
	
	/**
     * 获取备用02 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
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
     * @create time 2019-04-18 16:36:18
     */
	public void setUdf03(String udf03) {
		this.udf03 = udf03 == null ? null : udf03.trim();
	}
	
	/**
     * 获取备用03 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
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
     * @create time 2019-04-18 16:36:18
     */
	public void setUdf04(String udf04) {
		this.udf04 = udf04 == null ? null : udf04.trim();
	}
	
	/**
     * 获取备用04 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
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
     * @create time 2019-04-18 16:36:18
     */
	public void setUdf05(String udf05) {
		this.udf05 = udf05 == null ? null : udf05.trim();
	}
	
	/**
     * 获取备用05 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getUdf05() {
		return udf05;
	}
		
	/**
     * 设置数据来源 
     *
     * @param desc:数据来源
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setRd(String rd) {
		this.rd = rd == null ? null : rd.trim();
	}
	
	/**
     * 获取数据来源 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getRd() {
		return rd;
	}
		
	/**
     * 设置记录可用标识 
     *
     * @param desc:记录可用标识
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag == null ? null : activeFlag.trim();
	}
	
	/**
     * 获取记录可用标识 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getActiveFlag() {
		return activeFlag;
	}
		
	/**
     * 设置描述 
     *
     * @param desc:描述
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
	/**
     * 获取描述 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getRemark() {
		return remark;
	}
		
	/**
     * 设置创建人 
     *
     * @param desc:创建人
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy == null ? null : createdBy.trim();
	}
	
	/**
     * 获取创建人 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getCreatedBy() {
		return createdBy;
	}
		
	/**
     * 设置创建日期 
     *
     * @param desc:创建日期
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
     * 获取创建日期 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Date getCreatedDate() {
		return createdDate;
	}
		
	/**
     * 设置修改人 
     *
     * @param desc:修改人
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
	}
	
	/**
     * 获取修改人 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getModifiedBy() {
		return modifiedBy;
	}
		
	/**
     * 设置修改时间 
     *
     * @param desc:修改时间
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	/**
     * 获取修改时间 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public Date getModifiedDate() {
		return modifiedDate;
	}
		
	/**
     * 设置SAASID 
     *
     * @param desc:SAASID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public void setSaasid(String saasid) {
		this.saasid = saasid == null ? null : saasid.trim();
	}
	
	/**
     * 获取SAASID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 16:36:18
     */
	public String getSaasid() {
		return saasid;
	}
		
}