package com.ffe.service.service;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.service.model.DigitalCostsVendor;
import com.ffe.service.model.DigitalServTemplate;
import com.ffe.service.model.DigitalService;

public interface DigitalCostService {

	public List<DigitalCostsVendor> lstAllVendors() throws GTSException;
	public DigitalCostsVendor getVendor(Long vendorId) throws GTSException;
	public List<DigitalService> lstAllService() throws GTSException;
	public DigitalService getService(Long serviceId) throws GTSException;
	public List<DigitalServTemplate> lstAllServiceTemplate() throws GTSException;
	public DigitalServTemplate getServiceTemplate(Long servTemplateId) throws GTSException;
	public List<DigitalService> lstServicebyTemplate(Long templateid) throws GTSException;
	public List<DigitalServTemplate> lstServiceTemplateByCostType(String estimateCosttype) throws GTSException;
	public List<DigitalCostsVendor> lstVendorBasedonService(String serviceCode,String costType) throws GTSException;
	public Long getRateCardforServicebasedonVendor(String serviceCode,String costType,Long vendor_id) throws GTSException;
	public List<DigitalService> lstServiceByCostType(Long estimateCosttype) throws GTSException;
}
