package com.ffe.title.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.util.ErrorMessageUtil;
import com.ffe.title.dao.TitleDAO;
import com.ffe.title.message.SearchCriteria;
import com.ffe.title.model.Title;
import com.ffe.title.service.TitleService;

public class TitleServiceImpl implements TitleService {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	
	private TitleDAO titleDAO;
	
	public TitleDAO getTitleDAO() {
		return titleDAO;
	}

	public void setTitleDAO(TitleDAO TitleDAO) {
		this.titleDAO = TitleDAO;
	}

	public Title getTitle(long TitleID)	throws GTSException {
		logger.debug("Entering the TitleAdapterImpl.getTitle"+TitleID);
		Title TitleDomain = null;
		try {
			TitleDomain = titleDAO.findById(TitleID, false, null);
		}catch (Exception ex) {
			logger.error(
					" Exception occured in TitleAdapterImpl.getTitle :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting the TitleAdapterImpl.getTitle");
		return TitleDomain;
	}

	public Title saveTitle(Title titltDTO) throws GTSException {
		logger.debug("Entering into TitleAdapterImpl.saveTitle");
		try {
		
				titleDAO.update(titltDTO,null);
			

		}catch (Exception ex) {
			logger.error(
					" Exception occured in TitleAdapterImpl.saveTitle :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Entering into TitleAdapterImpl.saveTitle");
		return titltDTO;
	}

	/*private void copyAuditFieldFromParent(AbstractDomain child,
			AbstractDomain parent) {
		child.setCreatedBy(parent.getCreatedBy());
		child.setLastUpdatedBy(parent.getLastUpdatedBy());
		child.setDeletedFlag(parent.getDeletedFlag());
		child.setLastUpdatedDateTime(parent.getLastUpdatedDateTime());
		child.setCreatedDateTime(parent.getCreatedDateTime());
	}*/

	@Override
	public boolean isTitlePresent(long physicalTitleId, String wpn,String titleName) throws GTSException {
		boolean isphysicalTitlePresent = false;
		logger.debug("Entering into TitleAdapterImpl.isPhysicalTitlePresent");
		try {
			isphysicalTitlePresent= titleDAO.isTitlePresent(physicalTitleId,titleName,wpn);
		} catch (GTSException e) {
			logger.error("Caught Exception in TitleAdapterImpl.isPhysicalTitlePresent ",e);
			throw e;
		} catch (Exception e) {
			logger.error("Caught Exception in TitleAdapterImpl.isPhysicalTitlePresent ",e);
			throw new GTSException(ErrorMessageUtil.GENERIC_ERROR_CODE,ErrorMessageUtil.GENERIC_ERROR_MSG);
		}
		logger.debug("Exiting from TitleAdapterImpl.isPhysicalTitlePresent");
		return isphysicalTitlePresent;
	}

	public void deleteTitle(Title TitleDTO) throws GTSException {
		Title TitleDomain = null;
		
		logger.debug("Entering TitleAdapterImpl.deleteTitle") ;
		try {
			boolean response = titleDAO.deleteTitle(TitleDomain);
			logger.debug("response in adapterimpl"+response);
		
		} catch (Exception ex) {
			logger.error(" Exception occured in TitleAdapterImpl.deleteTitle :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting TitleAdapterImpl.deleteTitle") ;

	}

	@Override
	public List<Title> findTitle(SearchCriteria searchString) throws GTSException {
		List<Title> lstTitle = null;
		System.out.println("coming 2");
		logger.debug("Entering TitleAdapterImpl.deleteTitle") ;
		try {
			lstTitle = titleDAO.searchTitle(searchString);
			
		
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(" Exception occured in TitleAdapterImpl.deleteTitle :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting TitleAdapterImpl.deleteTitle") ;
		return lstTitle;
		
	}




}
