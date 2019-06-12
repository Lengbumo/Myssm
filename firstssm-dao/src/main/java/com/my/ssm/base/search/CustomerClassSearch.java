package com.my.ssm.base.search;

import java.util.Date;
import java.io.Serializable;
import com.my.ssm.core.basic.search.BasicSearch;
import java.math.BigDecimal;

/**
 * 客户大类基础表
 *
 * @com.my.ssm.base.search.CustomerClassSearch.java
 * @author system
 * @version 1.0.0
 * @since JDK 1.8
 * @create time 2019-04-18 10:51:27
 */
public class CustomerClassSearch extends BasicSearch implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id; // ID
	
	private Long corpId; // 公司ID
	
	private String corp; // 公司
	
	private Long orgnId; // 机构ID
	
	private String orgn; // 机构
	
	private String clsCode; // 客户大类编码
	
	private String clsName; // 中文名称
	
	private String clsNamee; // 英文名称
	
	private String clsDescr; // 中文描述
	
	private String clsDescre; // 英文描述
	
	private Long parentId; // 父级ID
	
	private String parentCode; // 父级编码
	
	private String clsLevel; // 级别
	
	private String endFlag; // 是否末级标志位
	
	private String udf01; // 备用01
	
	private String udf02; // 备用02
	
	private String udf03; // 备用03
	
	private String udf04; // 备用04
	
	private String udf05; // 备用05
	
	private String udf06; // 备用06
	
	private String udf07; // 备用07
	
	private String udf08; // 备用08
	
	private String udf09; // 备用09
	
	private String udf10; // 备用10
	
	private BigDecimal udf11; // 备用11
	
	private BigDecimal udf12; // 备用12
	
	private BigDecimal udf13; // 备用13
	
	private BigDecimal udf14; // 备用14
	
	private BigDecimal udf15; // 备用15
	
	private Long udf16; // 备用16
	
	private Long udf17; // 备用17
	
	private Long udf18; // 备用18
	
	private Long udf19; // 备用19
	
	private Long udf20; // 备用20
	
	private Date udf21; // 备用21
	
	private Date udf22; // 备用22
	
	private Date udf23; // 备用23
	
	private Date udf24; // 备用24
	
	private Date udf25; // 备用25
	
	private Date ts; // 时间戳
	
	private String rd; // 数据来源
	
	private String activeFlag; // 记录可用标识
	
	private String remark; // 描述
	
	private String createdBy; // 创建人
	
	private Date createdDate; // 创建日期
	
	private String modifiedBy; // 修改人
	
	private Date modifiedDate; // 修改时间
	
	private String saasid; // SAASID
	
	
	/**
     * 设置ID 
     *
     * @param desc:ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
     * 获取ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getId() {
		return id;
	}
		
	/**
     * 设置公司ID 
     *
     * @param desc:公司ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}
	
	/**
     * 获取公司ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getCorpId() {
		return corpId;
	}
		
	/**
     * 设置公司 
     *
     * @param desc:公司
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setCorp(String corp) {
		this.corp = corp == null ? null : corp.trim();
	}
	
	/**
     * 获取公司 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getCorp() {
		return corp;
	}
		
	/**
     * 设置机构ID 
     *
     * @param desc:机构ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setOrgnId(Long orgnId) {
		this.orgnId = orgnId;
	}
	
	/**
     * 获取机构ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getOrgnId() {
		return orgnId;
	}
		
	/**
     * 设置机构 
     *
     * @param desc:机构
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setOrgn(String orgn) {
		this.orgn = orgn == null ? null : orgn.trim();
	}
	
	/**
     * 获取机构 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getOrgn() {
		return orgn;
	}
		
	/**
     * 设置客户大类编码 
     *
     * @param desc:客户大类编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setClsCode(String clsCode) {
		this.clsCode = clsCode == null ? null : clsCode.trim();
	}
	
	/**
     * 获取客户大类编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getClsCode() {
		return clsCode;
	}
		
	/**
     * 设置中文名称 
     *
     * @param desc:中文名称
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setClsName(String clsName) {
		this.clsName = clsName == null ? null : clsName.trim();
	}
	
	/**
     * 获取中文名称 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getClsName() {
		return clsName;
	}
		
	/**
     * 设置英文名称 
     *
     * @param desc:英文名称
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setClsNamee(String clsNamee) {
		this.clsNamee = clsNamee == null ? null : clsNamee.trim();
	}
	
	/**
     * 获取英文名称 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getClsNamee() {
		return clsNamee;
	}
		
	/**
     * 设置中文描述 
     *
     * @param desc:中文描述
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setClsDescr(String clsDescr) {
		this.clsDescr = clsDescr == null ? null : clsDescr.trim();
	}
	
	/**
     * 获取中文描述 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getClsDescr() {
		return clsDescr;
	}
		
	/**
     * 设置英文描述 
     *
     * @param desc:英文描述
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setClsDescre(String clsDescre) {
		this.clsDescre = clsDescre == null ? null : clsDescre.trim();
	}
	
	/**
     * 获取英文描述 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getClsDescre() {
		return clsDescre;
	}
		
	/**
     * 设置父级ID 
     *
     * @param desc:父级ID
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	/**
     * 获取父级ID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getParentId() {
		return parentId;
	}
		
	/**
     * 设置父级编码 
     *
     * @param desc:父级编码
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode == null ? null : parentCode.trim();
	}
	
	/**
     * 获取父级编码 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getParentCode() {
		return parentCode;
	}
		
	/**
     * 设置级别 
     *
     * @param desc:级别
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setClsLevel(String clsLevel) {
		this.clsLevel = clsLevel == null ? null : clsLevel.trim();
	}
	
	/**
     * 获取级别 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getClsLevel() {
		return clsLevel;
	}
		
	/**
     * 设置是否末级标志位 
     *
     * @param desc:是否末级标志位
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setEndFlag(String endFlag) {
		this.endFlag = endFlag == null ? null : endFlag.trim();
	}
	
	/**
     * 获取是否末级标志位 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getEndFlag() {
		return endFlag;
	}
		
	/**
     * 设置备用01 
     *
     * @param desc:备用01
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf01(String udf01) {
		this.udf01 = udf01 == null ? null : udf01.trim();
	}
	
	/**
     * 获取备用01 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf02(String udf02) {
		this.udf02 = udf02 == null ? null : udf02.trim();
	}
	
	/**
     * 获取备用02 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf03(String udf03) {
		this.udf03 = udf03 == null ? null : udf03.trim();
	}
	
	/**
     * 获取备用03 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf04(String udf04) {
		this.udf04 = udf04 == null ? null : udf04.trim();
	}
	
	/**
     * 获取备用04 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf05(String udf05) {
		this.udf05 = udf05 == null ? null : udf05.trim();
	}
	
	/**
     * 获取备用05 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getUdf05() {
		return udf05;
	}
		
	/**
     * 设置备用06 
     *
     * @param desc:备用06
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf06(String udf06) {
		this.udf06 = udf06 == null ? null : udf06.trim();
	}
	
	/**
     * 获取备用06 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getUdf06() {
		return udf06;
	}
		
	/**
     * 设置备用07 
     *
     * @param desc:备用07
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf07(String udf07) {
		this.udf07 = udf07 == null ? null : udf07.trim();
	}
	
	/**
     * 获取备用07 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getUdf07() {
		return udf07;
	}
		
	/**
     * 设置备用08 
     *
     * @param desc:备用08
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf08(String udf08) {
		this.udf08 = udf08 == null ? null : udf08.trim();
	}
	
	/**
     * 获取备用08 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getUdf08() {
		return udf08;
	}
		
	/**
     * 设置备用09 
     *
     * @param desc:备用09
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf09(String udf09) {
		this.udf09 = udf09 == null ? null : udf09.trim();
	}
	
	/**
     * 获取备用09 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getUdf09() {
		return udf09;
	}
		
	/**
     * 设置备用10 
     *
     * @param desc:备用10
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf10(String udf10) {
		this.udf10 = udf10 == null ? null : udf10.trim();
	}
	
	/**
     * 获取备用10 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getUdf10() {
		return udf10;
	}
		
	/**
     * 设置备用11 
     *
     * @param desc:备用11
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf11(BigDecimal udf11) {
		this.udf11 = udf11;
	}
	
	/**
     * 获取备用11 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public BigDecimal getUdf11() {
		return udf11;
	}
		
	/**
     * 设置备用12 
     *
     * @param desc:备用12
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf12(BigDecimal udf12) {
		this.udf12 = udf12;
	}
	
	/**
     * 获取备用12 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public BigDecimal getUdf12() {
		return udf12;
	}
		
	/**
     * 设置备用13 
     *
     * @param desc:备用13
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf13(BigDecimal udf13) {
		this.udf13 = udf13;
	}
	
	/**
     * 获取备用13 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public BigDecimal getUdf13() {
		return udf13;
	}
		
	/**
     * 设置备用14 
     *
     * @param desc:备用14
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf14(BigDecimal udf14) {
		this.udf14 = udf14;
	}
	
	/**
     * 获取备用14 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public BigDecimal getUdf14() {
		return udf14;
	}
		
	/**
     * 设置备用15 
     *
     * @param desc:备用15
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf15(BigDecimal udf15) {
		this.udf15 = udf15;
	}
	
	/**
     * 获取备用15 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public BigDecimal getUdf15() {
		return udf15;
	}
		
	/**
     * 设置备用16 
     *
     * @param desc:备用16
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf16(Long udf16) {
		this.udf16 = udf16;
	}
	
	/**
     * 获取备用16 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getUdf16() {
		return udf16;
	}
		
	/**
     * 设置备用17 
     *
     * @param desc:备用17
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf17(Long udf17) {
		this.udf17 = udf17;
	}
	
	/**
     * 获取备用17 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getUdf17() {
		return udf17;
	}
		
	/**
     * 设置备用18 
     *
     * @param desc:备用18
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf18(Long udf18) {
		this.udf18 = udf18;
	}
	
	/**
     * 获取备用18 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getUdf18() {
		return udf18;
	}
		
	/**
     * 设置备用19 
     *
     * @param desc:备用19
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf19(Long udf19) {
		this.udf19 = udf19;
	}
	
	/**
     * 获取备用19 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getUdf19() {
		return udf19;
	}
		
	/**
     * 设置备用20 
     *
     * @param desc:备用20
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf20(Long udf20) {
		this.udf20 = udf20;
	}
	
	/**
     * 获取备用20 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Long getUdf20() {
		return udf20;
	}
		
	/**
     * 设置备用21 
     *
     * @param desc:备用21
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf21(Date udf21) {
		this.udf21 = udf21;
	}
	
	/**
     * 获取备用21 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Date getUdf21() {
		return udf21;
	}
		
	/**
     * 设置备用22 
     *
     * @param desc:备用22
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf22(Date udf22) {
		this.udf22 = udf22;
	}
	
	/**
     * 获取备用22 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Date getUdf22() {
		return udf22;
	}
		
	/**
     * 设置备用23 
     *
     * @param desc:备用23
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf23(Date udf23) {
		this.udf23 = udf23;
	}
	
	/**
     * 获取备用23 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Date getUdf23() {
		return udf23;
	}
		
	/**
     * 设置备用24 
     *
     * @param desc:备用24
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf24(Date udf24) {
		this.udf24 = udf24;
	}
	
	/**
     * 获取备用24 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Date getUdf24() {
		return udf24;
	}
		
	/**
     * 设置备用25 
     *
     * @param desc:备用25
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setUdf25(Date udf25) {
		this.udf25 = udf25;
	}
	
	/**
     * 获取备用25 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Date getUdf25() {
		return udf25;
	}
		
	/**
     * 设置时间戳 
     *
     * @param desc:时间戳
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	/**
     * 获取时间戳 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public Date getTs() {
		return ts;
	}
		
	/**
     * 设置数据来源 
     *
     * @param desc:数据来源
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public void setRd(String rd) {
		this.rd = rd == null ? null : rd.trim();
	}
	
	/**
     * 获取数据来源 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag == null ? null : activeFlag.trim();
	}
	
	/**
     * 获取记录可用标识 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
	/**
     * 获取描述 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy == null ? null : createdBy.trim();
	}
	
	/**
     * 获取创建人 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
     * 获取创建日期 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
	}
	
	/**
     * 获取修改人 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	/**
     * 获取修改时间 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
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
     * @create time 2019-04-18 10:51:27
     */
	public void setSaasid(String saasid) {
		this.saasid = saasid == null ? null : saasid.trim();
	}
	
	/**
     * 获取SAASID 
     *
     * @author system
     * @remark 方法初始化
     * @create time 2019-04-18 10:51:27
     */
	public String getSaasid() {
		return saasid;
	}
		
}