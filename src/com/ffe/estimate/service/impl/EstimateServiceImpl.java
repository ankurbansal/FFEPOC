package com.ffe.estimate.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.util.ErrorMessageUtil;
import com.ffe.estimate.dao.EstimateDAO;
import com.ffe.estimate.model.Estimate;
import com.ffe.estimate.service.EstimateService;

public class EstimateServiceImpl implements EstimateService {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	
	private EstimateDAO EstimateDAO;
	
	public EstimateDAO getEstimateDAO() {
		return EstimateDAO;
	}

	public void setEstimateDAO(EstimateDAO EstimateDAO) {
		this.EstimateDAO = EstimateDAO;
	}

	public Estimate getEstimate(long EstimateID)	throws GTSException {
		logger.debug("Entering the EstimateAdapterImpl.getEstimate"+EstimateID);
		Estimate EstimateDomain = null;
		try {
			EstimateDomain = EstimateDAO.findById(EstimateID, false, null);
		}catch (Exception ex) {
			logger.error(
					" Exception occured in EstimateAdapterImpl.getEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting the EstimateAdapterImpl.getEstimate");
		return EstimateDomain;
	}

	public Estimate saveEstimate(Estimate titltDTO) throws GTSException {
		logger.debug("Entering into EstimateAdapterImpl.saveEstimate");
		try {
		
				EstimateDAO.update(titltDTO,null);
			

		}catch (Exception ex) {
			logger.error(
					" Exception occured in EstimateAdapterImpl.saveEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Entering into EstimateAdapterImpl.saveEstimate");
		return titltDTO;
	}

	/*private void copyAuditFieldFromParent(AbstractDomain child,
			AbstractDomain parent) {
		child.setCreatedBy(parent.getCreatedBy());
		child.setLastUpdatedBy(parent.getLastUpdatedBy());
		child.setDeletedFlag(parent.getDeletedFlag());
		child.setLastUpdatedDateTime(parent.getLastUpdatedDateTime());
		child.setCreatedDateTime(parent.getCreatedDateTime());
	}*/

	@Override
	public boolean isEstimatePresent(long physicalEstimateId, String wpn,String EstimateName) throws GTSException {
		boolean isphysicalEstimatePresent = false;
		logger.debug("Entering into EstimateAdapterImpl.isPhysicalEstimatePresent");
		try {
			isphysicalEstimatePresent= EstimateDAO.isEstimatePresent(physicalEstimateId,EstimateName,wpn);
		} catch (GTSException e) {
			logger.error("Caught Exception in EstimateAdapterImpl.isPhysicalEstimatePresent ",e);
			throw e;
		} catch (Exception e) {
			logger.error("Caught Exception in EstimateAdapterImpl.isPhysicalEstimatePresent ",e);
			throw new GTSException(ErrorMessageUtil.GENERIC_ERROR_CODE,ErrorMessageUtil.GENERIC_ERROR_MSG);
		}
		logger.debug("Exiting from EstimateAdapterImpl.isPhysicalEstimatePresent");
		return isphysicalEstimatePresent;
	}

	public void deleteEstimate(Estimate EstimateDTO) throws GTSException {
		Estimate EstimateDomain = null;
		
		logger.debug("Entering EstimateAdapterImpl.deleteEstimate") ;
		try {
			boolean response = EstimateDAO.deleteEstimate(EstimateDomain);
			logger.debug("response in adapterimpl"+response);
		
		} catch (Exception ex) {
			logger.error(" Exception occured in EstimateAdapterImpl.deleteEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting EstimateAdapterImpl.deleteEstimate") ;

	}

	@Override
	public List<Estimate> findEstimate(String searchString) throws GTSException {
		
		return null;
	}




}
