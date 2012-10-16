package com.ffe.title.model;

/**
 * 
 */


import com.ffe.common.framework.model.AbstractDomain;


public class Title extends AbstractDomain {
	
	@Override
	public String toString() {
		return "Title [titleId=" + titleId + ", titleName=" + titleName
				+ ", wprNumber=" + wprNumber + ", productNumber="
				+ productNumber + ", mpaNumber=" + mpaNumber
				+ ", videoCatelog=" + videoCatelog + ", visa=" + visa
				+ ", edicode=" + edicode + ", releaseyear=" + releaseyear
				+ ", countryid=" + countryid + ", hh=" + hh + ", mm=" + mm
				+ ", ss=" + ss + ", aspectRatio=" + aspectRatio
				+ ", languageId=" + languageId + ", ActiveFlag=" + ActiveFlag
				+ ", rightsNotification=" + rightsNotification + ", comments="
				+ comments + ", lastUpdateDateandTime ="+super.getLastUpdatedDateTime() +" ]";
	}
	private Long titleId;
	private String titleName;
	
	private String wprNumber;
	private String productNumber ;
	private String mpaNumber ;
	private String videoCatelog ;
	private String visa;
	private String edicode;
	private String releaseyear ;
	public Long getHh() {
		return hh;
	}
	public void setHh(Long hh) {
		this.hh = hh;
	}
	public Long getMm() {
		return mm;
	}
	public void setMm(Long mm) {
		this.mm = mm;
	}
	public Long getSs() {
		return ss;
	}
	public void setSs(Long ss) {
		this.ss = ss;
	}
	private String countryid;
	private Long hh;
	private Long mm;
	private Long ss;
	private Long aspectRatio;
	private Long languageId;
	private Boolean ActiveFlag;
	private String rightsNotification;
	private String comments;
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
	public String getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(String releaseyear) {
		this.releaseyear = releaseyear;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	
	public Long getAspectRatio() {
		return aspectRatio;
	}
	public void setAspectRatio(Long aspectRatio) {
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	
	
}