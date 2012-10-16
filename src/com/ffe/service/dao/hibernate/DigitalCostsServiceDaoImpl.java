package com.ffe.service.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.hibernate.GenericHibernateDAO;
import com.ffe.service.dao.DigitalCostServiceDao;
import com.ffe.service.model.DigitalServTemplate;
import com.ffe.service.model.DigitalService;

public class DigitalCostsServiceDaoImpl extends GenericHibernateDAO<DigitalService> implements DigitalCostServiceDao {

	private static final Log logger = LogFactory.getLog(DigitalCostsServiceDaoImpl.class);
	@Override
	public Long getRateCardforServicebasedonVendor(String serviceCode,
			String costType, Long vendor_id) throws GTSException {
		// TODO Auto-generated method stub
		List resultSet = null;
		try{
			resultSet = getSession().createQuery("select digicostvendserv.unitCost from DigitalCostsVendorService digicostvendserv " +
					"where digicostvendserv.digiServCode = :digiServCode and " +
					"digicostvendserv.vendorId = :vendorId and " +
					"digicostvendserv.activityCode = :activity_code").
					setParameter("digiServCode",serviceCode).
					setParameter("vendorId",vendor_id).
					setParameter("activity_code",costType).list();
				
		}
		catch(DataAccessException dae)
		{
			
			logger.error(
					" Exception occured in  DigitalCostsServiceDaoImpl.getRateCardforServicebasedonVendor():",
					dae);
			throw new GTSException(dae.getMessage(), dae.getCause());
		}
		catch(Exception exp)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceDaoImpl.getRateCardforServicebasedonVendor():",
					exp);
			throw new GTSException(exp.getMessage(), exp.getCause());
		}
		if (null != resultSet && resultSet.size() > 0){
			return (Long)resultSet.get(0);
		}
		else{
			return 0l;
		}
			
	}
	@Override
	public List<DigitalService> lstServicebasedonCostType(
			Long estimateCosttype) throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalService> lstService = null;
		try {
		lstService = (List<DigitalService>)getSession().createQuery("from DigitalService digiserv where digiserv.activityId = :estimateCostType").
					  setParameter("estimateCostType",estimateCosttype)
					 .list();
								 
		logger.debug("List Size"+lstService.size());
		}
		catch(DataAccessException dae)
		{
			
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServicebasedonCostType():",
					dae);
			throw new GTSException(dae.getMessage(), dae.getCause());
		}
		catch(Exception exp)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServicebasedonCostType():",
					exp);
			throw new GTSException(exp.getMessage(), exp.getCause());
		}
		
		return lstService;
	}

}
