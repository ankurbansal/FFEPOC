// default package
// Generated Oct 11, 2012 5:26:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.ffe.service.model.DigitalServTempAssoc;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class DigitalServTempAssoc.
 * @see .DigitalServTempAssoc
 * @author Hibernate Tools
 */
public class DigitalServTempAssocHome {

	private static final Log log = LogFactory
			.getLog(DigitalServTempAssocHome.class);

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

	public void persist(DigitalServTempAssoc transientInstance) {
		log.debug("persisting DigitalServTempAssoc instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DigitalServTempAssoc instance) {
		log.debug("attaching dirty DigitalServTempAssoc instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DigitalServTempAssoc instance) {
		log.debug("attaching clean DigitalServTempAssoc instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DigitalServTempAssoc persistentInstance) {
		log.debug("deleting DigitalServTempAssoc instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DigitalServTempAssoc merge(DigitalServTempAssoc detachedInstance) {
		log.debug("merging DigitalServTempAssoc instance");
		try {
			DigitalServTempAssoc result = (DigitalServTempAssoc) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DigitalServTempAssoc findById(int id) {
		log.debug("getting DigitalServTempAssoc instance with id: " + id);
		try {
			DigitalServTempAssoc instance = (DigitalServTempAssoc) sessionFactory
					.getCurrentSession().get("DigitalServTempAssoc", id);
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

	public List<DigitalServTempAssoc> findByExample(
			DigitalServTempAssoc instance) {
		log.debug("finding DigitalServTempAssoc instance by example");
		try {
			List<DigitalServTempAssoc> results = (List<DigitalServTempAssoc>) sessionFactory
					.getCurrentSession().createCriteria("DigitalServTempAssoc")
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
