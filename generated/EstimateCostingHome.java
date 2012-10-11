// default package
// Generated Oct 11, 2012 5:26:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ffe.estimate.model.EstimateCosting;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class EstimateCosting.
 * @see .EstimateCosting
 * @author Hibernate Tools
 */
public class EstimateCostingHome {

	private static final Log log = LogFactory.getLog(EstimateCostingHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(EstimateCosting transientInstance) {
		log.debug("persisting EstimateCosting instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EstimateCosting instance) {
		log.debug("attaching dirty EstimateCosting instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EstimateCosting instance) {
		log.debug("attaching clean EstimateCosting instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EstimateCosting persistentInstance) {
		log.debug("deleting EstimateCosting instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EstimateCosting merge(EstimateCosting detachedInstance) {
		log.debug("merging EstimateCosting instance");
		try {
			EstimateCosting result = (EstimateCosting) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EstimateCosting findById(int id) {
		log.debug("getting EstimateCosting instance with id: " + id);
		try {
			EstimateCosting instance = (EstimateCosting) sessionFactory
					.getCurrentSession().get("EstimateCosting", id);
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

	public List<EstimateCosting> findByExample(EstimateCosting instance) {
		log.debug("finding EstimateCosting instance by example");
		try {
			List<EstimateCosting> results = (List<EstimateCosting>) sessionFactory
					.getCurrentSession().createCriteria("EstimateCosting")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
