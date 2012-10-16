package com.ffe.estimate.dao;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.GenericDao;
import com.ffe.estimate.model.Estimate;
import com.ffe.title.message.SearchCriteria;

public interface EstimateDAO extends GenericDao<Estimate>{
	public List<Estimate> searchEstimate(List<SearchCriteria> searchCriteriaList)	throws GTSException;
	
	public List<Estimate> findEstimate(String searchString)throws GTSException;
			
	public Boolean isEstimatePresent(long EstimateId, String EstimateName, String wpr)throws GTSException;
		
	public boolean deleteEstimate(Estimate Estimate)	throws GTSException;
	
}
