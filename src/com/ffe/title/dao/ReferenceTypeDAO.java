package com.ffe.title.dao;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.GenericDao;
import com.ffe.title.model.ReferenceType;

public interface ReferenceTypeDAO extends GenericDao<ReferenceType> {
	public List<ReferenceType> getReferenceTypesByRefName(String entityType, String referenceTypeName) throws GTSException;
}
