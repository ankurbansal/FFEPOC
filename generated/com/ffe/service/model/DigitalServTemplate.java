package com.ffe.service.model;
// default package
// Generated Oct 11, 2012 5:26:27 PM by Hibernate Tools 3.4.0.CR1

/**
 * DigitalServTemplate generated by hbm2java
 */
public class DigitalServTemplate implements java.io.Serializable {

	private int digiServTempId;
	private String digiServTempName;
	private String crtBy;
	private String uptBy;
	private String delFlag;
	private String desc;

	public DigitalServTemplate() {
	}

	public DigitalServTemplate(String digiServTempName, String crtBy,
			String uptBy, String delFlag, String desc) {
		this.digiServTempName = digiServTempName;
		this.crtBy = crtBy;
		this.uptBy = uptBy;
		this.delFlag = delFlag;
		this.desc = desc;
	}

	public int getDigiServTempId() {
		return this.digiServTempId;
	}

	public void setDigiServTempId(int digiServTempId) {
		this.digiServTempId = digiServTempId;
	}

	public String getDigiServTempName() {
		return this.digiServTempName;
	}

	public void setDigiServTempName(String digiServTempName) {
		this.digiServTempName = digiServTempName;
	}

	public String getCrtBy() {
		return this.crtBy;
	}

	public void setCrtBy(String crtBy) {
		this.crtBy = crtBy;
	}

	public String getUptBy() {
		return this.uptBy;
	}

	public void setUptBy(String uptBy) {
		this.uptBy = uptBy;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
