package com.my.ssm.sys.search;

import java.util.Date;

import com.my.ssm.core.basic.search.BasicSearch;


/**
 * 系统菜单表
 *
 * @com.my.ssm.sys.search.MenuSearch.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-05-05 15:20:54
 */
public class MenuSearch extends BasicSearch {
	
	private static final long serialVersionUID = 1L;

	private Long id; // ID
	
	private Long corpId; // 默认公司ID
	
	private String corp; // 默认公司CODE
	
	private Long orgnId; // 默认机构ID
	
	private String orgn; // 默认机构CODE
	
	private Long moduleId; // 所属模块ID
	
	private String moduleCode; // 所属模块编码
	
	private String menuIcon; // 菜单图标
	
	private String menuCode; // 菜单编码
	
	private String menuName; // 菜单名称
	
	private String menuSort; // 排序
	
	private String sysUrl; // 系统URL
	
	private String menuUrl; // URL
	
	private Long parentId; // 上级菜单ID
	
	private String rd; // 来源
	
	private String activeFlag; // 是否激活
	
	private String remark; // 备注
	
	private String createdBy; // 创建人
	
	private Date createdDate; // 创建时间
	
	private String modifiedBy; // 修改人
	
	private Date modifiedDate; // 修改时间
	
	private String saasid; // SAASID
	
	private String isParent; // 是否只查询最上层按钮(0：只查询无下级 1：是)
	
	
	/**
     * 设置ID 
     *
     * @param desc:ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
     * 获取ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
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
     * @create time 2019-05-05 15:20:54
     */
	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}
	
	/**
     * 获取默认公司ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
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
     * @create time 2019-05-05 15:20:54
     */
	public void setCorp(String corp) {
		this.corp = corp == null ? null : corp.trim();
	}
	
	/**
     * 获取默认公司CODE 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
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
     * @create time 2019-05-05 15:20:54
     */
	public void setOrgnId(Long orgnId) {
		this.orgnId = orgnId;
	}
	
	/**
     * 获取默认机构ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
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
     * @create time 2019-05-05 15:20:54
     */
	public void setOrgn(String orgn) {
		this.orgn = orgn == null ? null : orgn.trim();
	}
	
	/**
     * 获取默认机构CODE 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getOrgn() {
		return orgn;
	}
		
	/**
     * 设置所属模块ID 
     *
     * @param desc:所属模块ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	
	/**
     * 获取所属模块ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public Long getModuleId() {
		return moduleId;
	}
		
	/**
     * 设置所属模块编码 
     *
     * @param desc:所属模块编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode == null ? null : moduleCode.trim();
	}
	
	/**
     * 获取所属模块编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getModuleCode() {
		return moduleCode;
	}
		
	/**
     * 设置菜单图标 
     *
     * @param desc:菜单图标
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon == null ? null : menuIcon.trim();
	}
	
	/**
     * 获取菜单图标 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getMenuIcon() {
		return menuIcon;
	}
		
	/**
     * 设置菜单编码 
     *
     * @param desc:菜单编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode == null ? null : menuCode.trim();
	}
	
	/**
     * 获取菜单编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getMenuCode() {
		return menuCode;
	}
		
	/**
     * 设置菜单名称 
     *
     * @param desc:菜单名称
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}
	
	/**
     * 获取菜单名称 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getMenuName() {
		return menuName;
	}
		
	/**
     * 设置排序 
     *
     * @param desc:排序
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setMenuSort(String menuSort) {
		this.menuSort = menuSort == null ? null : menuSort.trim();
	}
	
	/**
     * 获取排序 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getMenuSort() {
		return menuSort;
	}
		
	/**
     * 设置系统URL 
     *
     * @param desc:系统URL
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setSysUrl(String sysUrl) {
		this.sysUrl = sysUrl == null ? null : sysUrl.trim();
	}
	
	/**
     * 获取系统URL 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getSysUrl() {
		return sysUrl;
	}
		
	/**
     * 设置URL 
     *
     * @param desc:URL
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl == null ? null : menuUrl.trim();
	}
	
	/**
     * 获取URL 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getMenuUrl() {
		return menuUrl;
	}
		
	/**
     * 设置上级菜单ID 
     *
     * @param desc:上级菜单ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	/**
     * 获取上级菜单ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public Long getParentId() {
		return parentId;
	}
		
	/**
     * 设置来源 
     *
     * @param desc:来源
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setRd(String rd) {
		this.rd = rd == null ? null : rd.trim();
	}
	
	/**
     * 获取来源 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getRd() {
		return rd;
	}
		
	/**
     * 设置是否激活 
     *
     * @param desc:是否激活
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag == null ? null : activeFlag.trim();
	}
	
	/**
     * 获取是否激活 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getActiveFlag() {
		return activeFlag;
	}
		
	/**
     * 设置备注 
     *
     * @param desc:备注
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
	/**
     * 获取备注 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
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
     * @create time 2019-05-05 15:20:54
     */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy == null ? null : createdBy.trim();
	}
	
	/**
     * 获取创建人 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getCreatedBy() {
		return createdBy;
	}
		
	/**
     * 设置创建时间 
     *
     * @param desc:创建时间
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
     * 获取创建时间 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
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
     * @create time 2019-05-05 15:20:54
     */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
	}
	
	/**
     * 获取修改人 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
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
     * @create time 2019-05-05 15:20:54
     */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	/**
     * 获取修改时间 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
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
     * @create time 2019-05-05 15:20:54
     */
	public void setSaasid(String saasid) {
		this.saasid = saasid == null ? null : saasid.trim();
	}
	
	/**
     * 获取SAASID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-05-05 15:20:54
     */
	public String getSaasid() {
		return saasid;
	}

	/**
	 * 是否只查询最上层按钮(0：只查询无下级 1：是)
	 * 
	 * @Title getIsParent    
	 * @return          
	 *  
	 * @author WJ
	 * @date   2019年5月8日 上午11:16:53
	 */
	public String getIsParent() {
		return isParent;
	}

	
	/**
	 * 是否只查询最上层按钮(0：只查询无下级 1：是)
	 * 
	 * @Title setIsParent    
	 * @param isParent          
	 *  
	 * @author WJ
	 * @date   2019年5月8日 上午11:17:00
	 */
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
		
}