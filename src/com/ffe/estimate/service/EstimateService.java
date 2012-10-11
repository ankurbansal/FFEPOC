package com.ffe.estimate.service;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.estimate.model.Estimate;

/*
 * Adapter class 
 */
public interface EstimateService {

	public Estimate getEstimate(long EstimateID) throws GTSException;

	public List<Estimate> findEstimate(String searchString) throws GTSException;

	public Estimate saveEstimate(Estimate Estimate) throws GTSException;

	public void deleteEstimate(Estimate Estimate) throws GTSException;
	
	

	boolean isEstimatePresent(long physicalEstimateId, String wpn, String EstimateName)
			throws GTSException;
	}
