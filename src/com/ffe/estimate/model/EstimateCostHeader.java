package com.ffe.estimate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.ffe.common.framework.model.AbstractDomain;

public class EstimateCostHeader extends AbstractDomain implements Serializable{

	private static final long serialVersionUID = -474410540486681157L;
	private Long estCostHeadId;
	private Estimate estimate;
	public Estimate getEstimate() {
		return estimate;
	}
	public void setEstimate(Estimate estimate) {
		this.estimate = estimate;
	}
	private Date releaseDate;
	private BigDecimal filmLength;
	private Long noOfReels;
	private Long totPrints;
	private String headerOV;
	private String desc;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Long getEstCostHeadId() {
		return estCostHeadId;
	}
	public void setEstCostHeadId(Long estCostHeadId) {
		this.estCostHeadId = estCostHeadId;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public BigDecimal getFilmLength() {
		return filmLength;
	}
	public void setFilmLength(BigDecimal filmLength) {
		this.filmLength = filmLength;
	}
	public Long getNoOfReels() {
		return noOfReels;
	}
	public void setNoOfReels(Long noOfReels) {
		this.noOfReels = noOfReels;
	}
	public Long getTotPrints() {
		return totPrints;
	}
	public void setTotPrints(Long totPrints) {
		this.totPrints = totPrints;
	}
	public String getHeaderOV() {
		return headerOV;
	}
	public void setHeaderOV(String headerOV) {
		this.headerOV = headerOV;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public EstimateCostHeader(Long estCostHeadId, Long estimateId,
			Date releaseDate, BigDecimal filmLength, Long noOfReels,
			Long totPrints, String headerOV) {
		super();
		this.estCostHeadId = estCostHeadId;
		this.releaseDate = releaseDate;
		this.filmLength = filmLength;
		this.noOfReels = noOfReels;
		this.totPrints = totPrints;
		this.headerOV = headerOV;
	}
	public EstimateCostHeader() {
		super();
	}
	
}
