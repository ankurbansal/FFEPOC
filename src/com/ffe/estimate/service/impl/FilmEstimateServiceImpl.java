package com.ffe.estimate.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ffe.common.exception.GTSException;
import com.ffe.estimate.dao.FilmEstimateDAO;
import com.ffe.estimate.model.FilmEstimate;
import com.ffe.estimate.model.PrintCostCategory;
import com.ffe.estimate.service.FilmEstimateService;

public class FilmEstimateServiceImpl extends FilmEstimateService {
	private Logger logger= LoggerFactory.getLogger(FilmEstimateServiceImpl.class);


	private FilmEstimateDAO filmEstimateDAO;
	
	@Override
	public FilmEstimate getFilmEstimate(long filmEstimateID)throws GTSException {
		logger.debug("Entering the FilmEstimateServiceImpl.getFilmEstimate"+filmEstimateID);
		FilmEstimate estimate = null;
		try {
			estimate = filmEstimateDAO.findById(filmEstimateID, false, null);
		}catch (Exception ex) {
			logger.error(
					" Exception occured in FilmEstimateServiceImpl.getFilmEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting the FilmEstimateServiceImpl.getFilmEstimate");
		return estimate;
	}

	
	
	public FilmEstimateDAO getFilmEstimateDAO() {
		return filmEstimateDAO;
	}



	public void setFilmEstimateDAO(FilmEstimateDAO filmEstimateDAO) {
		this.filmEstimateDAO = filmEstimateDAO;
	}



	@Override
	public FilmEstimate saveFilmEstimate(FilmEstimate estimate) throws GTSException {
		logger.debug("Entering into FilmEstimateServiceImpl.saveEstimate");
		FilmEstimate estimateResult = null;
		try {
		
			List<PrintCostCategory> lstEstCostng = estimate.getLstPrintCostCategories();
			for (PrintCostCategory estCost:lstEstCostng){
				estCost.setFilmEstimate(estimate);
			}
			estimateResult = this.filmEstimateDAO.update(estimate,null);
		}catch (Exception ex) {
			logger.error(" Exception occured in FilmEstimateServiceImpl.saveEstimate :",
					ex.getMessage());
			ex.printStackTrace();
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Entering into FilmEstimateServiceImpl.saveEstimate");
		return estimateResult;
	}
	
}
