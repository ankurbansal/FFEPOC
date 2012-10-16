package com.ffe.estimate.service;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.estimate.model.Estimate;

/*
 * Adapter class 
 */
public interface EstimateService {

	public Estimate getEstimate(long estimateID) throws GTSException;

	public List<Estimate> findEstimate(String searchString) throws GTSException;

	public Estimate saveEstimate(Estimate estimate) throws GTSException;

	public void deleteEstimate(Estimate estimate) throws GTSException;
	
	

	boolean isEstimatePresent(long physicalEstimateId, String wpn, String estimateName)
			throws GTSException;
	public Estimate submitEstimate(Estimate estimate) throws GTSException;
	public Estimate approveEstimate(Estimate estimate) throws GTSException;
	public Estimate rejectEstimate(Estimate estimate) throws GTSException;
	}
