package com.ffe.estimate.dao.hibernate;
// Generated Oct 11, 2012 5:26:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.hibernate.GenericHibernateDAO;
import com.ffe.estimate.dao.EstimateDAO;
import com.ffe.estimate.model.Estimate;
import com.ffe.title.message.SearchCriteria;

/**
 * Home object for domain model class Estimate.
 * @see .Estimate
 * @author Hibernate Tools
 */
public class EstimateDAOImpl extends GenericHibernateDAO<Estimate> implements EstimateDAO {
	private static final Log log = LogFactory.getLog(EstimateDAOImpl.class);

	private final SessionFactory sessionFactory = getSessionFactory();


	

	public void delete(Estimate persistentInstance) {
		log.debug("deleting Estimate instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Estimate findEstimate(int id) {
		log.debug("getting Estimate instance with id: " + id);
		try {
			Estimate instance = (Estimate) sessionFactory.getCurrentSession()
					.get("Estimate", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Estimate> searchEstimate(List<SearchCriteria> searchCriteriaList)
			throws GTSException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Boolean isEstimatePresent(long EstimateId, String EstimateName,
			String wpr) throws GTSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEstimate(Estimate Estimate) throws GTSException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Estimate> findEstimate(String searchString) throws GTSException {
		// TODO Auto-generated method stub
		return null;
	}
}
