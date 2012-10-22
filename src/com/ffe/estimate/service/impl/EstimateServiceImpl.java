package com.ffe.estimate.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.runtime.StatefulKnowledgeSession;
import org.jbpm.process.workitem.wsht.WSHumanTaskHandler;
import org.jbpm.task.AccessType;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.ContentData;
import org.jbpm.task.service.TaskClient;
import org.jbpm.task.service.responsehandlers.BlockingTaskOperationResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.util.ConstantUtil;
import com.ffe.common.framework.util.ErrorMessageUtil;
import com.ffe.estimate.dao.EstimateDAO;
import com.ffe.estimate.model.Estimate;
import com.ffe.estimate.model.EstimateCostType;
import com.ffe.estimate.model.EstimateCosting;
import com.ffe.estimate.service.EstimateService;
import com.ffe.process.task.model.EstimateTaskSummary;
import com.ffe.process.task.service.FFEHumanTaskService;

public class EstimateServiceImpl implements EstimateService {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	
	private EstimateDAO estimateDAO;
	private StatefulKnowledgeSession statfulknowsession;
	private FFEHumanTaskService ffeHumanTaskService;
	

	public FFEHumanTaskService getFfeHumanTaskService() {
		return ffeHumanTaskService;
	}

	public void setFfeHumanTaskService(FFEHumanTaskService ffeHumanTaskService) {
		this.ffeHumanTaskService = ffeHumanTaskService;
	}

	public StatefulKnowledgeSession getStatfulknowsession() {
		return statfulknowsession;
	}

	public void setStatfulknowsession(StatefulKnowledgeSession statfulknowsession) {
		this.statfulknowsession = statfulknowsession;
	}

	public EstimateDAO getEstimateDAO() {
		return estimateDAO;
	}

	public void setEstimateDAO(EstimateDAO estimateDAO) {
		this.estimateDAO = estimateDAO;
	}

	public Estimate getEstimate(long estimateID)	throws GTSException {
		logger.debug("Entering the EstimateServiceImpl.getEstimate"+estimateID);
		Estimate estimate = null;
		try {
			estimate = estimateDAO.findById(estimateID, false, null);
		}catch (Exception ex) {
			logger.error(
					" Exception occured in EstimateServiceImpl.getEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting the EstimateServiceImpl.getEstimate");
		return estimate;
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
	public boolean isEstimatePresent(long physicalEstimateId, String wpn,String estimateName) throws GTSException {
		boolean isphysicalEstimatePresent = false;
		logger.debug("Entering into EstimateServiceImpl.isPhysicalEstimatePresent");
		try {
			isphysicalEstimatePresent= estimateDAO.isEstimatePresent(physicalEstimateId,estimateName,wpn);
		} catch (GTSException gts) {
			logger.error("Caught Exception in EstimateServiceImpl.isPhysicalEstimatePresent ",gts);
			throw gts;
		} catch (Exception ex) {
			logger.error("Caught Exception in EstimateServiceImpl.isPhysicalEstimatePresent ",ex);
			throw new GTSException(ErrorMessageUtil.GENERIC_ERROR_CODE,ErrorMessageUtil.GENERIC_ERROR_MSG);
		}
		logger.debug("Exiting from EstimateServiceImpl.isPhysicalEstimatePresent");
		return isphysicalEstimatePresent;
	}

	public void deleteEstimate(Estimate estimateDTO) throws GTSException {
		Estimate estimateDomain = null;
		
		logger.debug("Entering EstimateServiceImpl.deleteEstimate") ;
		try {
			boolean response = estimateDAO.deleteEstimate(estimateDTO);
			logger.debug("response in adapterimpl"+response);
		
		} catch (Exception ex) {
			logger.error(" Exception occured in EstimateServiceImpl.deleteEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting EstimateServiceImpl.deleteEstimate") ;

	}

	@Override
	public List<Estimate> findEstimate(String searchString) throws GTSException {
		
		return null;
	}

	@Override
	public Estimate approveEstimate(Long taskId,String userName,Estimate estimate) throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into EstimateServiceImpl.approveEstimate");
		Estimate estimateResult = null;
		try {
			//Calculating the total cost for each of the service
			
			estimate.setEstCostStaId(ConstantUtil.STATUS_MAP.get("Approve"));
			estimateResult = estimateDAO.update(estimate,null);
			Map<String,Object> inputMap = new HashMap<String, Object>();
			inputMap.put("estimateobj", estimateResult);
			ffeHumanTaskService.completeTask(taskId, userName, inputMap);
			
		}catch (Exception ex) {
			logger.error(
					" Exception occured in EstimateServiceImpl.approveEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Entering into EstimateServiceImpl.approveEstimate");
		return estimateResult;
	}
	

	@Override
	public Estimate rejectEstimate(Long taskId,String userName,Estimate estimate) throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into EstimateServiceImpl.rejectEstimate");
		Estimate estimateResult = null;
		try {
			//Calculating the total cost for each of the service
			
			estimate.setEstCostStaId(ConstantUtil.STATUS_MAP.get("Reject"));
			estimateResult = estimateDAO.update(estimate,null);
			Map<String,Object> inputMap = new HashMap<String, Object>();
			inputMap.put("estimateobj", estimateResult);
			ffeHumanTaskService.failTask(taskId, userName, inputMap);
		}catch (Exception ex) {
			logger.error(
					" Exception occured in EstimateServiceImpl.rejectEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Entering into EstimateServiceImpl.rejectEstimate");
		return estimateResult;
	}

	public Estimate saveEstimate(Estimate estimate) throws GTSException {
		logger.debug("Entering into EstimateServiceImpl.saveEstimate");
		Estimate estimateResult = null;
		try {
			//Calculating the total cost for each of the service
			
			estimate.setEstCostStaId(ConstantUtil.STATUS_MAP.get("Save"));
			List<EstimateCosting> lstEstCostng = estimate.getLstEstimateCosting();
			for (EstimateCosting estCost:lstEstCostng){
				double totCost = estCost.getQuantity().doubleValue() * estCost.getLocalCurrentCost().doubleValue();
				estCost.setTotalcost(new BigDecimal(totCost));
			}
			
			estimateResult = estimateDAO.update(estimate,null);
		}catch (Exception ex) {
			logger.error(
					" Exception occured in EstimateServiceImpl.saveEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Entering into EstimateServiceImpl.saveEstimate");
		return estimateResult;
	}
	
	@Override
	public Estimate submitEstimate(Estimate estimate) throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into EstimateServiceImpl.submitEstimate");
		Estimate estimateResult = null;
		try {
			//Calculating the total cost for each of the service
			
			estimate.setEstCostStaId(ConstantUtil.STATUS_MAP.get("Submit"));
			List<EstimateCosting> lstEstCostng = estimate.getLstEstimateCosting();
			for (EstimateCosting estCost:lstEstCostng){
				double totCost = estCost.getQuantity().doubleValue() * estCost.getLocalCurrentCost().doubleValue();
				estCost.setTotalcost(new BigDecimal(totCost));
			}
			
			estimateResult = estimateDAO.update(estimate,null);
			triggerRegionalApprovalProcess(estimateResult);
		}catch (Exception ex) {
			logger.error(
					" Exception occured in EstimateServiceImpl.submitEstimate :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Entering into EstimateServiceImpl.submitEstimate");
		return estimateResult;
	}

	@Override
	public void triggerRegionalApprovalProcess(Estimate estimate)
			throws GTSException {
		logger.debug("Entering into EstimateServiceImpl.triggerRegionalApprovalProcess");
		try
		{
		Map<String,Object> processInputMap = new HashMap<String, Object>();
		processInputMap.put("estimate", estimate);
		processInputMap.put("logger", logger);
		statfulknowsession.startProcess(ConstantUtil.REGIONAL_APPROVAL_PROCESS_NAME,processInputMap);
		}
		catch(Exception ex){
			logger.error(
					" Exception occured in EstimateServiceImpl.triggerRegionalApprovalProcess :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into EstimateServiceImpl.triggerRegionalApprovalProcess");
	}

	@Override
	public List<EstimateTaskSummary> lstEstimateTaskAssginedtoUser(String userName,String language)
			throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into EstimateServiceImpl.lstTaskAssginedtoUser");
		List<TaskSummary> lstTaskSummary = null;
		List<EstimateTaskSummary> lstEstimateTaskSummary = null;
		EstimateTaskSummary estimateTaskSummary = null;
		try{
			lstTaskSummary = ffeHumanTaskService.lstTaskAssginedtoUser(userName,language);
			if (null != lstTaskSummary){
				lstEstimateTaskSummary = new ArrayList<EstimateTaskSummary>();
				for(TaskSummary taskSummary:lstTaskSummary){
					estimateTaskSummary = new EstimateTaskSummary();
					estimateTaskSummary.setTaskSummary(taskSummary);
					HashMap<String,Object> contentMap = ffeHumanTaskService.getTaskData(taskSummary.getId());
					if (null != contentMap){
						Estimate estimate = (Estimate)contentMap.get("estimate");
						if (null != estimate){
							estimateTaskSummary.setEstimate(estimate);
						}
					}
					else{
						estimateTaskSummary.setEstimate(null);
					}
					lstEstimateTaskSummary.add(estimateTaskSummary);
				}
			}
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in EstimateServiceImpl.lstTaskAssginedtoUser :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into EstimateServiceImpl.lstTaskAssginedtoUser");
		return lstEstimateTaskSummary;
	}
	@Override
	public List<EstimateTaskSummary> lstEstimateTaskAssginedtoGroup(String groupName,String language)
			throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into EstimateServiceImpl.lstTaskAssginedtoGroup");
		List<TaskSummary> lstTaskSummary = null;
		List<EstimateTaskSummary> lstEstimateTaskSummary = null;
		EstimateTaskSummary estimateTaskSummary = null;
		try{
			lstTaskSummary = ffeHumanTaskService.lstTaskAssginedtoGroup(groupName,language);
			if (null != lstTaskSummary){
				lstEstimateTaskSummary = new ArrayList<EstimateTaskSummary>();
				for(TaskSummary taskSummary:lstTaskSummary){
					estimateTaskSummary = new EstimateTaskSummary();
					estimateTaskSummary.setTaskSummary(taskSummary);
					HashMap<String,Object> contentMap = ffeHumanTaskService.getTaskData(taskSummary.getId());
					if (null != contentMap){
						Estimate estimate = (Estimate)contentMap.get("estimate");
						if (null != estimate){
							estimateTaskSummary.setEstimate(estimate);
						}
					}
					else{
						estimateTaskSummary.setEstimate(null);
					}
					lstEstimateTaskSummary.add(estimateTaskSummary);
				}
			}
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in EstimateServiceImpl.lstTaskAssginedtoGroup :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into EstimateServiceImpl.lstTaskAssginedtoGroup");
		return lstEstimateTaskSummary;
	}

	@Override
	public void claimEstimateTask(Long taskId, String userName)throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into EstimateServiceImpl.claimTask");
		
		try{
			logger.debug("Claiming the task\t"+taskId+"\t as Admin");
			ffeHumanTaskService.claimTask(taskId, userName);
			logger.debug("Task is Claimed\t");
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in EstimateServiceImpl.claimTask :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into EstimateServiceImpl.claimTask");
	}
	

	


}
