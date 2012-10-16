package com.ffe.service.dao;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.GenericDao;
import com.ffe.service.model.DigitalCostsVendor;

public interface DigitalCostVendorDao extends GenericDao<DigitalCostsVendor> {
public List<DigitalCostsVendor> lstVendorBasedonService(String serviceCode,String costType) throws GTSException;
}
