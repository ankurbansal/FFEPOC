// default package
// Generated Oct 11, 2012 5:26:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ffe.estimate.model.EstimateCostType;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class EstimateCostType.
 * @see .EstimateCostType
 * @author Hibernate Tools
 */
public class EstimateCostTypeHome {

	private static final Log log = LogFactory
			.getLog(EstimateCostTypeHome.class);

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

	public void persist(EstimateCostType transientInstance) {
		log.debug("persisting EstimateCostType instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EstimateCostType instance) {
		log.debug("attaching dirty EstimateCostType instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EstimateCostType instance) {
		log.debug("attaching clean EstimateCostType instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EstimateCostType persistentInstance) {
		log.debug("deleting EstimateCostType instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EstimateCostType merge(EstimateCostType detachedInstance) {
		log.debug("merging EstimateCostType instance");
		try {
			EstimateCostType result = (EstimateCostType) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EstimateCostType findById(int id) {
		log.debug("getting EstimateCostType instance with id: " + id);
		try {
			EstimateCostType instance = (EstimateCostType) sessionFactory
					.getCurrentSession().get("EstimateCostType", id);
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

	public List<EstimateCostType> findByExample(EstimateCostType instance) {
		log.debug("finding EstimateCostType instance by example");
		try {
			List<EstimateCostType> results = (List<EstimateCostType>) sessionFactory
					.getCurrentSession().createCriteria("EstimateCostType")
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
