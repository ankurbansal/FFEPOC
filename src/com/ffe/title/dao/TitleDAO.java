/**
 * 
 */
package com.ffe.title.dao;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.GenericDao;
import com.ffe.title.message.SearchCriteria;
import com.ffe.title.model.Title;

public interface TitleDAO extends GenericDao<Title> {

	
	
	public List<Title> findTitle(String searchString)throws GTSException;
			
	public Boolean isTitlePresent(long TitleId, String titleName, String wpr)throws GTSException;
		
	public boolean deleteTitle(Title Title)	throws GTSException;

	public List<Title> searchTitle(SearchCriteria searchCriteria)	throws GTSException;
}
