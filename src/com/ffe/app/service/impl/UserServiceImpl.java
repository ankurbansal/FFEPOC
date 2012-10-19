package com.ffe.app.service.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ffe.app.dao.TerritoryDao;
import com.ffe.app.dao.UserDao;
import com.ffe.app.model.Territory;
import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.model.UserProfile;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private TerritoryDao territoryDao;
	
	
	public TerritoryDao getTerritoryDao() {
		return territoryDao;
	}


	public void setTerritoryDao(TerritoryDao territoryDao) {
		this.territoryDao = territoryDao;
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	
	

	@Override
	public UserDetails saveUser(UserProfile userProfile)
			throws GTSException {
		System.out.println("entering with UserServiceImpl.LoadUserByUserName-->"+ userProfile);
		UserDetails userDetails= null;
		try {
			userDao.update(userProfile,"");
			
		} catch (Exception gtsException) {
			gtsException.printStackTrace();
		
		}
		System.out.println("exiting  with UserServiceImpl.LoadUserByUserName");
		return userDetails;
	}


	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		System.out.println("entering with UserServiceImpl.LoadUserByUserName-->"+ userName);
		UserDetails userDetails= null;
		try {
			userDetails=userDao.findUser(userName);
			System.out.println("userObject ?"+ userDetails);
			if (null==userDetails){
				throw new UsernameNotFoundException("NO USER EXISTS");
			}
		} catch (Exception gtsException) {
			gtsException.printStackTrace();
			throw new UsernameNotFoundException("Some ERROR OCCURRED");
		}
		System.out.println("exiting  with UserServiceImpl.LoadUserByUserName");
		return userDetails;
	}


	@Override
	public List<Territory> lstTerritory() throws GTSException {
		
		return territoryDao.getAll();
	}

}
