package com.ffe.service.dao;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.GenericDao;
import com.ffe.service.model.DigitalService;

public interface DigitalCostServiceDao extends GenericDao<DigitalService>{
	public Long getRateCardforServicebasedonVendor(String serviceCode,String costType,Long vendor_id) throws GTSException;
	public List<DigitalService> lstServicebasedonCostType(Long estimateCosttype) throws GTSException;
}
