package com.ffe.app.model;
// Generated Oct 11, 2012 5:26:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Region generated by hbm2java
 */
public class Region implements java.io.Serializable {

	private int regionid;
	private String name;
	private String code;
	private String description;
	private String createdby;
	private String lastupdatedby;
	private Date lastupdateddatetime;
	private Date createddatetime;
	private String deletedflag;

	public Region() {
	}

	public Region(int regionid) {
		this.regionid = regionid;
	}

	public Region(int regionid, String name, String code, String description,
			String createdby, String lastupdatedby, Date lastupdateddatetime,
			Date createddatetime, String deletedflag) {
		this.regionid = regionid;
		this.name = name;
		this.code = code;
		this.description = description;
		this.createdby = createdby;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddatetime = lastupdateddatetime;
		this.createddatetime = createddatetime;
		this.deletedflag = deletedflag;
	}

	public int getRegionid() {
		return this.regionid;
	}

	public void setRegionid(int regionid) {
		this.regionid = regionid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getLastupdatedby() {
		return this.lastupdatedby;
	}

	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	public Date getLastupdateddatetime() {
		return this.lastupdateddatetime;
	}

	public void setLastupdateddatetime(Date lastupdateddatetime) {
		this.lastupdateddatetime = lastupdateddatetime;
	}

	public Date getCreateddatetime() {
		return this.createddatetime;
	}

	public void setCreateddatetime(Date createddatetime) {
		this.createddatetime = createddatetime;
	}

	public String getDeletedflag() {
		return this.deletedflag;
	}

	public void setDeletedflag(String deletedflag) {
		this.deletedflag = deletedflag;
	}

}