package com.ffe.app.service.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ffe.app.model.Territory;
import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.model.UserProfile;

public interface UserService extends UserDetailsService {

	public UserDetails saveUser(UserProfile userProfile) throws GTSException;

	public List<Territory> lstTerritory() throws GTSException;

}
