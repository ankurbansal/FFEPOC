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
			List<UserProfile> Users;
			Users = userDao.findUser(userName);
			if(null!=Users && Users.size()>0){
				userDetails=Users.get(0);
				System.out.println("userDetails " + userDetails);
			}else{
				throw new UsernameNotFoundException("Please check the UserName and Password");	
			}
		} catch (GTSException gtsException) {
			gtsException.printStackTrace();
		
		}
		System.out.println("exiting  with UserServiceImpl.LoadUserByUserName");
		return userDetails;
	}

}
