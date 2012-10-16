package com.ffe.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ffe.common.exception.GTSException;
import com.ffe.service.dao.DigitalCostServiceDao;
import com.ffe.service.dao.DigitalCostServiceTemplateDao;
import com.ffe.service.dao.DigitalCostVendorDao;
import com.ffe.service.model.DigitalCostsVendor;
import com.ffe.service.model.DigitalServTempAssoc;
import com.ffe.service.model.DigitalServTemplate;
import com.ffe.service.model.DigitalService;
import com.ffe.service.service.DigitalCostService;

public class DigitalCostsServiceImpl implements DigitalCostService {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	
	private DigitalCostVendorDao digitalCostVendorDao;
	private DigitalCostServiceDao digitalCostServiceDao;
	private DigitalCostServiceTemplateDao digitalCostServiceTemplateDao;
	
	
	public DigitalCostVendorDao getDigitalCostVendorDao() {
		return digitalCostVendorDao;
	}

	public void setDigitalCostVendorDao(DigitalCostVendorDao digitalCostVendorDao) {
		this.digitalCostVendorDao = digitalCostVendorDao;
	}

	public DigitalCostServiceDao getDigitalCostServiceDao() {
		return digitalCostServiceDao;
	}

	public void setDigitalCostServiceDao(DigitalCostServiceDao digitalCostServiceDao) {
		this.digitalCostServiceDao = digitalCostServiceDao;
	}

	public DigitalCostServiceTemplateDao getDigitalCostServiceTemplateDao() {
		return digitalCostServiceTemplateDao;
	}

	public void setDigitalCostServiceTemplateDao(
			DigitalCostServiceTemplateDao digitalCostServiceTemplateDao) {
		this.digitalCostServiceTemplateDao = digitalCostServiceTemplateDao;
	}


	@Override
	public List<DigitalCostsVendor> lstAllVendors() throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalCostsVendor> lstDigCostVend;
		try {
			lstDigCostVend = digitalCostVendorDao.getAll();
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstAllVendors():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return lstDigCostVend;
	}
	
	@Override
	public  DigitalCostsVendor getVendor(Long vendorId) throws GTSException {
		// TODO Auto-generated method stub
		DigitalCostsVendor digiCostVendor;
		try {
			digiCostVendor = digitalCostVendorDao.findById(vendorId,false, null);
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.getVendor():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return digiCostVendor;
	}

	@Override
	public DigitalService getService(Long serviceId) throws GTSException {
		// TODO Auto-generated method stub
		DigitalService digitalService;
		try {
			digitalService = digitalCostServiceDao.findById(serviceId,false, null);
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.getService():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return digitalService;
	}

	@Override
	public List<DigitalService> lstAllService() throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalService> lstDigCostServ;
		try {
			lstDigCostServ = digitalCostServiceDao.getAll();
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstAllService():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return lstDigCostServ;
	}

	@Override
	public DigitalServTemplate getServiceTemplate(Long servTemplateId)
			throws GTSException {
		// TODO Auto-generated method stub
		DigitalServTemplate digitalServiceTemplate;
		try {
			digitalServiceTemplate = digitalCostServiceTemplateDao.findById(servTemplateId,false, null);
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.getServiceTemplate():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return digitalServiceTemplate;
	}

	@Override
	public List<DigitalServTemplate> lstAllServiceTemplate()
			throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalServTemplate> lstDigCostServTemplate;
		try {
			lstDigCostServTemplate = digitalCostServiceTemplateDao.getAll();
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstAllServiceTemplate():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return lstDigCostServTemplate;
	}
	
	@Override
	public List<DigitalService> lstServicebyTemplate(Long templateid)
			throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalService> lstDigitalServices;
		try {
		lstDigitalServices = digitalCostServiceTemplateDao.lstServicebyTemplate(templateid);
		}
		catch(Exception ex){
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServicebyTemplate():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return lstDigitalServices;
		
	}

	@Override
	public List<DigitalServTemplate> lstServiceTemplateByCostType(
			String estimateCosttype) throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalServTemplate> lstDigitalServiceTemplate;
		try{
			lstDigitalServiceTemplate = digitalCostServiceTemplateDao.lstServiceTemplateByCostType(estimateCosttype);	
		}
		catch(Exception ex){
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServiceTemplateByCostType():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return lstDigitalServiceTemplate;
	}

	@Override
	public List<DigitalCostsVendor> lstVendorBasedonService(String serviceCode,
			String costType) throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalCostsVendor> lstVendor;
		try{
			lstVendor = digitalCostVendorDao.lstVendorBasedonService(serviceCode, costType);
		}
		catch(Exception ex){
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstVendorBasedonService():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return lstVendor;
	}

	@Override
	public Long getRateCardforServicebasedonVendor(String serviceCode,
			String costType, Long vendor_id) throws GTSException {
		// TODO Auto-generated method stub
		Long rate_card = 0l;
		try
		{
			rate_card = digitalCostServiceDao.getRateCardforServicebasedonVendor(serviceCode, costType, vendor_id);
		}
		catch(Exception ex){
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.getRateCardforServicebasedonVendor():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return rate_card;
	}

	@Override
	public List<DigitalService> lstServiceByCostType(Long estimateCosttype)
			throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalService> lstDigitalService;
		try{
			lstDigitalService = digitalCostServiceDao.lstServicebasedonCostType(estimateCosttype);
		}
		catch(Exception ex){
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServiceByCostType():",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		return lstDigitalService;
	}	
	
}
