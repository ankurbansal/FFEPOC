package com.ffe.app.service.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ffe.app.dao.UserDao;
import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.model.UserProfile;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		System.out.println("entering with UserServiceImpl.LoadUserByUserName-->"+ userName);
		UserDetails userDetails= null;
		try {
			
			userDetails = userDao.findUser(userName);
			
		} catch (GTSException gtsException) {
			gtsException.printStackTrace();
		
		}
		System.out.println("exiting  with UserServiceImpl.LoadUserByUserName");
		return userDetails;
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

}
