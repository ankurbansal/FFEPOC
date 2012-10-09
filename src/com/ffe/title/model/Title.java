package com.ffe.title.model;

/**
 * 
 */


import java.util.Date;

import com.ffe.common.framework.model.AbstractDomain;


public class Title extends AbstractDomain {
	private Long titleId;
	private String wprNumber;
	private String productNumber ;
	private String mpaNumber ;
	private String videoCatelog ;
	private String visa;
	private String edicode;
	private Date releaseyear ;
	private ReferenceType countryid;
	private Date runningtime;
	
	public Long getTitleId() {
		return titleId;
	}
	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}
	public String getWprNumber() {
		return wprNumber;
	}
	public void setWprNumber(String wprNumber) {
		this.wprNumber = wprNumber;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getMpaNumber() {
		return mpaNumber;
	}
	public void setMpaNumber(String mpaNumber) {
		this.mpaNumber = mpaNumber;
	}
	public String getVideoCatelog() {
		return videoCatelog;
	}
	public void setVideoCatelog(String videoCatelog) {
		this.videoCatelog = videoCatelog;
	}
	public String getVisa() {
		return visa;
	}
	public void setVisa(String visa) {
		this.visa = visa;
	}
	public String getEdicode() {
		return edicode;
	}
	public void setEdicode(String edicode) {
		this.edicode = edicode;
	}
	public Date getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(Date releaseyear) {
		this.releaseyear = releaseyear;
	}
	public ReferenceType getCountryid() {
		return countryid;
	}
	public void setCountryid(ReferenceType countryid) {
		this.countryid = countryid;
	}
	public Date getRunningtime() {
		return runningtime;
	}
	public void setRunningtime(Date runningtime) {
		this.runningtime = runningtime;
	}
	public String getAspectRatio() {
		return aspectRatio;
	}
	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}
	public Long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}
	public Boolean getActiveFlag() {
		return ActiveFlag;
	}
	public void setActiveFlag(Boolean activeFlag) {
		ActiveFlag = activeFlag;
	}
	public String getRightsNotification() {
		return rightsNotification;
	}
	public void setRightsNotification(String rightsNotification) {
		this.rightsNotification = rightsNotification;
	}
	private String aspectRatio;
	private Long languageId;
	private Boolean ActiveFlag;
	private String rightsNotification;
	private String comment;
	public String getComments() {
		
		// TODO Auto-generated method stub
		return comment;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}