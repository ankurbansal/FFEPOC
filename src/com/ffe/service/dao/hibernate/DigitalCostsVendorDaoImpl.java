package com.ffe.service.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.hibernate.GenericHibernateDAO;
import com.ffe.service.dao.DigitalCostVendorDao;
import com.ffe.service.model.DigitalCostsVendor;
import com.ffe.service.model.DigitalServTemplate;

public class DigitalCostsVendorDaoImpl extends GenericHibernateDAO<DigitalCostsVendor>  implements DigitalCostVendorDao{

	private static final Log logger = LogFactory.getLog(DigitalCostsVendorDaoImpl.class);
	@Override
	public List<DigitalCostsVendor> lstVendorBasedonService(String serviceCode,String costType)
			throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalCostsVendor> lstVendor = null;
		try
		{
			lstVendor = (List<DigitalCostsVendor>)getSession().createQuery("select digicostvendor from DigitalCostsVendor digicostvendor,DigitalCostsVendorService digicostvendorservice,DigitalService digitalservice "+
					 "where digicostvendor.vendorId = digicostvendorservice.vendorId and " +
					 "digicostvendorservice.activityCode = :activityCode and " +
					 "digicostvendorservice.digiServCode = :digiServCode group by digicostvendor.vendorId").
					 setParameter("digiServCode",serviceCode).
					 setParameter("activityCode",costType)
					 .list();
			logger.debug("List Size"+lstVendor.size());
		}
		catch(DataAccessException dae)
		{
			
			logger.error(
					" Exception occured in  DigitalCostsVendorDaoImpl.lstVendorBasedonService():",
					dae);
			throw new GTSException(dae.getMessage(), dae.getCause());
		}
		catch(Exception exp)
		{
			logger.error(
					" Exception occured in  DigitalCostsVendorDaoImpl.lstVendorBasedonService():",
					exp);
			throw new GTSException(exp.getMessage(), exp.getCause());
		}
		return lstVendor;
	}

}
