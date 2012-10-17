package com.ffe.app.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.model.UserProfile;

public interface UserService extends UserDetailsService {

	public UserDetails saveUser(UserProfile userProfile) throws GTSException;

}
