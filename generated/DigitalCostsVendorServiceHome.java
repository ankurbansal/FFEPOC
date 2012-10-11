// default package
// Generated Oct 11, 2012 5:26:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class DigitalCostsVendorService.
 * @see .DigitalCostsVendorService
 * @author Hibernate Tools
 */
public class DigitalCostsVendorServiceHome {

	private static final Log log = LogFactory
			.getLog(DigitalCostsVendorServiceHome.class);

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

	public void persist(DigitalCostsVendorService transientInstance) {
		log.debug("persisting DigitalCostsVendorService instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DigitalCostsVendorService instance) {
		log.debug("attaching dirty DigitalCostsVendorService instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DigitalCostsVendorService instance) {
		log.debug("attaching clean DigitalCostsVendorService instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DigitalCostsVendorService persistentInstance) {
		log.debug("deleting DigitalCostsVendorService instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DigitalCostsVendorService merge(
			DigitalCostsVendorService detachedInstance) {
		log.debug("merging DigitalCostsVendorService instance");
		try {
			DigitalCostsVendorService result = (DigitalCostsVendorService) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DigitalCostsVendorService findById(int id) {
		log.debug("getting DigitalCostsVendorService instance with id: " + id);
		try {
			DigitalCostsVendorService instance = (DigitalCostsVendorService) sessionFactory
					.getCurrentSession().get("DigitalCostsVendorService", id);
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

	public List<DigitalCostsVendorService> findByExample(
			DigitalCostsVendorService instance) {
		log.debug("finding DigitalCostsVendorService instance by example");
		try {
			List<DigitalCostsVendorService> results = (List<DigitalCostsVendorService>) sessionFactory
					.getCurrentSession()
					.createCriteria("DigitalCostsVendorService")
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
