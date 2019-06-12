package com.my.ssm.core.basic.model;

/**
 * 下拉框对象
 * 
 * @ClassName  ComBox        
 * 
 * @author WJ
 * @date   2019年5月5日 下午6:04:30   
 *
 */
public class ComBox extends BasicModel {
	
	private static final long serialVersionUID = 2007551715365975266L;

	private String code; // 字典编码

    private String codeName; // 中文名称

    private String codeEname; // 英文名称

    private String descr; // 描述

    private Long showSeq; // 显示顺序

    private String udf01; // 备用01

    private String udf02; // 备用02

    private String udf03; // 备用03

    private String udf04; // 备用04

    private String udf05; // 备用05

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeEname() {
		return codeEname;
	}

	public void setCodeEname(String codeEname) {
		this.codeEname = codeEname;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Long getShowSeq() {
		return showSeq;
	}

	public void setShowSeq(Long showSeq) {
		this.showSeq = showSeq;
	}

	public String getUdf01() {
		return udf01;
	}

	public void setUdf01(String udf01) {
		this.udf01 = udf01;
	}

	public String getUdf02() {
		return udf02;
	}

	public void setUdf02(String udf02) {
		this.udf02 = udf02;
	}

	public String getUdf03() {
		return udf03;
	}

	public void setUdf03(String udf03) {
		this.udf03 = udf03;
	}

	public String getUdf04() {
		return udf04;
	}

	public void setUdf04(String udf04) {
		this.udf04 = udf04;
	}

	public String getUdf05() {
		return udf05;
	}

	public void setUdf05(String udf05) {
		this.udf05 = udf05;
	}
}
