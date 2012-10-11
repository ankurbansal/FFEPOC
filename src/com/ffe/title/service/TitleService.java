package com.ffe.title.service;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.title.message.SearchCriteria;
import com.ffe.title.model.Title;

/*
 * Adapter class 
 */
public interface TitleService {

	public Title getTitle(long TitleID) throws GTSException;

	public Title saveTitle(Title Title) throws GTSException;

	public void deleteTitle(Title Title) throws GTSException;
	
	

	boolean isTitlePresent(long physicalTitleId, String wpn, String titleName)
			throws GTSException;

	public List<Title> findTitle(SearchCriteria searchString) throws GTSException;
	
	}
