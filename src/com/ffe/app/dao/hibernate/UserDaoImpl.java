package com.ffe.app.dao.hibernate;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.AuthorityUtils;

import com.ffe.app.dao.UserDao;
import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.hibernate.GenericHibernateDAO;
import com.ffe.common.framework.model.UserProfile;
import com.ffe.common.framework.model.UserRoleAssoc;

public class UserDaoImpl extends GenericHibernateDAO<UserProfile> 
implements UserDao{

	@Override
	public UserProfile findUser(String userName) throws GTSException {
		System.out.println("Entering UserDAOImpl.searchUser");
		UserProfile User = null;
		try {
			System.out.println("userName --->"+userName);
			List<UserProfile> Users = (List<UserProfile>) getSession()
					.createQuery(
							" from com.ffe.common.framework.model.UserProfile user where upper(user.email) = :emailId ")
					.setParameter("emailId",userName.toUpperCase())
					.list();
			
			if (null!=Users && Users.size()>0) {
				User=Users.get(0);
				StringBuilder builder = new StringBuilder();
				if(null!=User.userRoleAssocs && User.userRoleAssocs.size()>0){
					for (UserRoleAssoc userRoleAssoc : User.userRoleAssocs) {
						builder.append(userRoleAssoc.getRole().getCode()).append(",");
					}
					builder.deleteCharAt(builder.lastIndexOf(","));
				}
				User.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(builder.toString()));
			}
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			System.out.println("Exception in AddressDAOImpl.searchUser");
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		System.out.println("Exiting UserDAOImpl.searchUser ");
		return User;

	}
}
