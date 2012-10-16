package com.ffe.service.dao;

import java.util.List;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.dao.GenericDao;
import com.ffe.service.model.DigitalServTemplate;
import com.ffe.service.model.DigitalService;

public interface DigitalCostServiceTemplateDao extends GenericDao<DigitalServTemplate>{
	public List<DigitalService> lstServicebyTemplate(Long templateid) throws GTSException;
	public List<DigitalServTemplate> lstServiceTemplateByCostType(String estimateCosttype) throws GTSException;
}
