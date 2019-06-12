package com.my.ssm.core.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础对象
 * 
 * @ClassName  BasicModel        
 * 
 * @author WJ
 * @date   2019年5月5日 下午4:21:38   
 *
 */
public class BasicModel implements Serializable{

	private static final long serialVersionUID = 5171145869948160929L;

	private Long id; // ID
	
	private Long corpId; // 公司ID
	
	private String corp; // 公司CODE
	
	private Long orgnId; // 机构ID
	
	private String orgn; // 机构CODE
	
	private String rd; // 来源
	
	private String activeFlag; // 是否激活
	
	private String remark; // 备注
	
	private String createdBy; // 创建人
	
	private Date createdDate; // 创建时间
	
	private String modifiedBy; // 修改人
	
	private Date modifiedDate; // 修改时间
	
	private String saasid; // SAASID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCorpId() {
		return corpId;
	}

	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public Long getOrgnId() {
		return orgnId;
	}

	public void setOrgnId(Long orgnId) {
		this.orgnId = orgnId;
	}

	public String getOrgn() {
		return orgn;
	}

	public void setOrgn(String orgn) {
		this.orgn = orgn;
	}

	public String getRd() {
		return rd;
	}

	public void setRd(String rd) {
		this.rd = rd;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getSaasid() {
		return saasid;
	}

	public void setSaasid(String saasid) {
		this.saasid = saasid;
	}
}
