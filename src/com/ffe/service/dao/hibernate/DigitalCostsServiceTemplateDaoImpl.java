package com.ffe.service.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.dao.DataAccessException;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.hibernate.GenericHibernateDAO;
import com.ffe.estimate.dao.hibernate.EstimateDAOImpl;
import com.ffe.service.dao.DigitalCostServiceTemplateDao;
import com.ffe.service.model.DigitalServTempAssoc;
import com.ffe.service.model.DigitalServTemplate;
import com.ffe.service.model.DigitalService;
import com.ffe.title.model.Title;

public class DigitalCostsServiceTemplateDaoImpl extends GenericHibernateDAO<DigitalServTemplate> implements DigitalCostServiceTemplateDao {

	private static final Log logger = LogFactory.getLog(DigitalCostsServiceTemplateDaoImpl.class);

	
	@Override
	public List<DigitalService> lstServicebyTemplate(Long templateid) throws GTSException {
		// TODO Auto-generated method stub
		DigitalServTemplate digiServTemplate = null;
		List<DigitalService> digiServicelst = null;
		try {
			digiServTemplate = findById(templateid,false, null);
			if ( null != digiServTemplate){
				List<DigitalServTempAssoc> digiServTempAssoc = digiServTemplate.getDigitalServTempAssoclst();
				if ( null != digiServTempAssoc && digiServTempAssoc.size() != 0 )
				{
					digiServicelst = new ArrayList<DigitalService>();
					for (DigitalServTempAssoc digitalServAssoc:digiServTempAssoc){
						Hibernate.initialize(digitalServAssoc.getDigitalService());
						digiServicelst.add(digitalServAssoc.getDigitalService());
					}
				}
			}
		}
		catch(DataAccessException dae)
		{
			
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServicebyTemplate():",
					dae);
			throw new GTSException(dae.getMessage(), dae.getCause());
		}
		catch(Exception exp)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServicebyTemplate():",
					exp);
			throw new GTSException(exp.getMessage(), exp.getCause());
		}
		return digiServicelst;
	}
	@Override
	public List<DigitalServTemplate> lstServiceTemplateByCostType(
			String estimateCosttype) throws GTSException {
		// TODO Auto-generated method stub
		List<DigitalServTemplate> lstServiceTemplate = null;
		try {
		lstServiceTemplate = (List<DigitalServTemplate>)getSession().createQuery("select digiservtemp from DigitalServTemplate digiservtemp,DigitalServTempAssoc digiservassoc,EstimateCostType estcosttype "+
								 "where digiservtemp.digiServTempId = digiservassoc.digiServTemplateId and " +
								 "digiservassoc.activityCode = estcosttype.estimateCostId and " +
								 "estcosttype.name = :estimatecostname group by digiservtemp.digiServTempId").setParameter("estimatecostname",estimateCosttype).list();
		logger.debug("List Size"+lstServiceTemplate.size());
		}
		catch(DataAccessException dae)
		{
			
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServiceTemplateByCostType():",
					dae);
			throw new GTSException(dae.getMessage(), dae.getCause());
		}
		catch(Exception exp)
		{
			logger.error(
					" Exception occured in  DigitalCostsServiceImpl.lstServiceTemplateByCostType():",
					exp);
			throw new GTSException(exp.getMessage(), exp.getCause());
		}
		
		return lstServiceTemplate;
	}

}
