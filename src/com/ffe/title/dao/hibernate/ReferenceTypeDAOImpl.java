package com.ffe.title.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.hibernate.GenericHibernateDAO;
import com.ffe.common.framework.util.ConstantUtil;
import com.ffe.title.dao.ReferenceTypeDAO;
import com.ffe.title.model.ReferenceType;

public class ReferenceTypeDAOImpl extends GenericHibernateDAO<ReferenceType> implements ReferenceTypeDAO {

	private static Logger logger = LoggerFactory.getLogger(ReferenceTypeDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReferenceType> getReferenceTypesByRefName(String entityType, String referenceTypeName) throws GTSException {
		logger.info("Entering ReferenceTypeDAOImpl.getReferenceTypesByRefName input == " + entityType + " == "+referenceTypeName);
		List<ReferenceType> values = null;
		try{
			String className = entityType;
			StringBuilder query = new StringBuilder("from ");
			
			Query queryResult = getSession().createQuery(query.toString());
			queryResult.setParameter("referenceTypeName", referenceTypeName);
			logger.debug("query ---- > "+queryResult.toString());
			values = (List<ReferenceType>)queryResult.list();
		}catch (DataAccessException ex) {
			logger.error("DataAccessException in ReferenceTypeDAOImpl.getReferenceTypesByRefName", ex);
			throw new GTSException(ex.getMessage(), ex.getCause());
		}catch (Exception ex) {
			logger.error("Exception in ReferenceTypeDAOImpl.getReferenceTypesByRefName", ex);
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.info("Exiting ReferenceTypeDAOImpl.getReferenceTypesByRefName");
		return values;
	}
	
}
