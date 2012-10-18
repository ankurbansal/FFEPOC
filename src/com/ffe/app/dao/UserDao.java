package com.ffe.app.dao;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.GenericDao;
import com.ffe.common.framework.model.UserProfile;

public interface UserDao extends GenericDao<UserProfile> {

	public UserProfile findUser(String userName) throws GTSException;

}
