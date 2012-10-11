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
 * Home object for domain model class DigitalCostsVendor.
 * @see .DigitalCostsVendor
 * @author Hibernate Tools
 */
public class DigitalCostsVendorHome {

	private static final Log log = LogFactory
			.getLog(DigitalCostsVendorHome.class);

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

	public void persist(DigitalCostsVendor transientInstance) {
		log.debug("persisting DigitalCostsVendor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DigitalCostsVendor instance) {
		log.debug("attaching dirty DigitalCostsVendor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DigitalCostsVendor instance) {
		log.debug("attaching clean DigitalCostsVendor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DigitalCostsVendor persistentInstance) {
		log.debug("deleting DigitalCostsVendor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DigitalCostsVendor merge(DigitalCostsVendor detachedInstance) {
		log.debug("merging DigitalCostsVendor instance");
		try {
			DigitalCostsVendor result = (DigitalCostsVendor) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DigitalCostsVendor findById(int id) {
		log.debug("getting DigitalCostsVendor instance with id: " + id);
		try {
			DigitalCostsVendor instance = (DigitalCostsVendor) sessionFactory
					.getCurrentSession().get("DigitalCostsVendor", id);
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

	public List<DigitalCostsVendor> findByExample(DigitalCostsVendor instance) {
		log.debug("finding DigitalCostsVendor instance by example");
		try {
			List<DigitalCostsVendor> results = (List<DigitalCostsVendor>) sessionFactory
					.getCurrentSession().createCriteria("DigitalCostsVendor")
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
