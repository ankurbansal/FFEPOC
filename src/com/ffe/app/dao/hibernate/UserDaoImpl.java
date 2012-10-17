package com.ffe.app.dao.hibernate;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ffe.app.dao.UserDao;
import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.hibernate.GenericHibernateDAO;
import com.ffe.common.framework.model.UserProfile;

public class UserDaoImpl extends GenericHibernateDAO<UserProfile> 
implements UserDao{

	@Override
	public List<UserProfile> findUser(String userName) throws GTSException {
		System.out.println("Entering UserDAOImpl.searchUser");
		List<UserProfile> Users = null;
		try {
			
			Users = (List<UserProfile>) getSession()
					.createQuery(
							" from com.ffe.common.framework.model.UserProfile User where upper(uniqueId) = :stringQuery2 or upper(emailid) = :stringQuery ")
					.setParameter("stringQuery",
							"%" + userName.toUpperCase() + "%")
					.setParameter("stringQuery2",
							"%" + userName.toUpperCase() + "%")
					.list();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			System.out.println("Exception in AddressDAOImpl.searchUser");
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		System.out.println("Exiting UserDAOImpl.searchUser ");
		return Users;

	}
}
