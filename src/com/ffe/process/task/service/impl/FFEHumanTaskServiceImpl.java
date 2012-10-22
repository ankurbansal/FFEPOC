package com.ffe.process.task.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.task.AccessType;
import org.jbpm.task.Content;
import org.jbpm.task.Task;
import org.jbpm.task.TaskData;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.ContentData;
import org.jbpm.task.service.TaskClient;
import org.jbpm.task.service.responsehandlers.BlockingGetContentResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingGetTaskResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskOperationResponseHandler;
import org.jbpm.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ffe.common.exception.GTSException;
import com.ffe.process.task.service.FFEHumanTaskService;

public class FFEHumanTaskServiceImpl implements FFEHumanTaskService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private BlockingTaskSummaryResponseHandler taskSummaryResponseHandler;
	private BlockingTaskOperationResponseHandler taskOperationHandler;
	private BlockingGetTaskResponseHandler taskResponseHandler;
	private BlockingGetContentResponseHandler taskContentResponseHandler;
	
	public BlockingGetTaskResponseHandler getTaskResponseHandler() {
		return taskResponseHandler;
	}
	public BlockingGetContentResponseHandler getTaskContentResponseHandler() {
		return taskContentResponseHandler;
	}
	public void setTaskContentResponseHandler(
			BlockingGetContentResponseHandler taskContentResponseHandler) {
		this.taskContentResponseHandler = taskContentResponseHandler;
	}
	public void setTaskResponseHandler(
			BlockingGetTaskResponseHandler taskResponseHandler) {
		this.taskResponseHandler = taskResponseHandler;
	}
	private TaskClient taskClient;
	
	public BlockingTaskSummaryResponseHandler getTaskSummaryResponseHandler() {
		return taskSummaryResponseHandler;
	}
	public void setTaskSummaryResponseHandler(
			BlockingTaskSummaryResponseHandler taskSummaryResponseHandler) {
		this.taskSummaryResponseHandler = taskSummaryResponseHandler;
	}
	public BlockingTaskOperationResponseHandler getTaskOperationHandler() {
		return taskOperationHandler;
	}
	public void setTaskOperationHandler(
			BlockingTaskOperationResponseHandler taskOperationHandler) {
		this.taskOperationHandler = taskOperationHandler;
	}
	public TaskClient getTaskClient() {
		return taskClient;
	}
	public void setTaskClient(TaskClient taskClient) {
		this.taskClient = taskClient;
	}

	
	
	@Override
	public List<TaskSummary> lstTaskAssginedtoUser(String userName,String language)
			throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into FFEHumanTaskServiceImpl.lstTaskAssginedtoUser");
		List<TaskSummary> lstTaskSummary = null;
		try{
			taskClient.getTasksAssignedAsPotentialOwner(userName,language, taskSummaryResponseHandler);
			lstTaskSummary = taskSummaryResponseHandler.getResults();
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in FFEHumanTaskServiceImpl.lstTaskAssginedtoUser :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into FFEHumanTaskServiceImpl.lstTaskAssginedtoUser");
		return lstTaskSummary;
	}
	@Override
	public List<TaskSummary> lstTaskAssginedtoGroup(String groupName,String language)
			throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into FFEHumanTaskServiceImpl.lstTaskAssginedtoGroup");
		List<TaskSummary> lstTaskSummary = null;
		try{
			taskClient.getTasksAssignedAsPotentialGroup(groupName,language, taskSummaryResponseHandler);
			lstTaskSummary = taskSummaryResponseHandler.getResults();
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in FFEHumanTaskServiceImpl.lstTaskAssginedtoGroup :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into FFEHumanTaskServiceImpl.lstTaskAssginedtoGroup");
		return lstTaskSummary;
	}

	@Override
	public void claimTask(Long taskId, String userName)throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into FFEHumanTaskServiceImpl.claimTask");
		
		try{
			logger.debug("Claiming the task\t"+taskId+"\t as Admin");
			taskClient.claim(taskId,"Administrator", taskOperationHandler);
			taskOperationHandler.waitTillDone(5000);
			logger.debug("Delegating the task to the user\t"+userName);
			taskClient.delegate(taskId,"Administrator",userName,taskOperationHandler);
			taskOperationHandler.waitTillDone(5000);
			logger.debug("Task is Claimed\t");
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in FFEHumanTaskServiceImpl.claimTask :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into FFEHumanTaskServiceImpl.claimTask");
	}
	
	@Override
	public void startTask(Long taskId, String userName) throws GTSException {
		// TODO Auto-generated method stub
			logger.debug("Entering into FFEHumanTaskServiceImpl.startTask");
		
		try{
			logger.debug("Starting the Task---------->\t"+taskId);
			taskClient.start(taskId,userName,taskOperationHandler);
			taskOperationHandler.waitTillDone(5000);
			logger.debug("Task started------->\t"+taskId);
			
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in FFEHumanTaskServiceImpl.startTask :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into FFEHumanTaskServiceImpl.startTask");
	}

	@Override
	public void stopTask(Long taskId, String userName) throws GTSException {
		// TODO Auto-generated method stub
			logger.debug("Entering into FFEHumanTaskServiceImpl.stopTask");
		
		try{
			logger.debug("Stopping the Task---------->\t"+taskId);
			taskClient.stop(taskId,userName,taskOperationHandler);
			taskOperationHandler.waitTillDone(5000);
			logger.debug("Task Stopped------->\t"+taskId);
			
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in FFEHumanTaskServiceImpl.stopTask :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into FFEHumanTaskServiceImpl.stopTask");
	}

	@Override
	public void completeTask(Long taskId,String userName,Map<String, Object> inputMap) throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into FFEHumanTaskServiceImpl.completeTask");
		
		try{
			logger.debug("Completing the Task---------->\t"+taskId);
			ContentData contentData = null;
			if(inputMap != null)
			{
				ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
				ObjectOutputStream objectOutput = null;
				objectOutput = new ObjectOutputStream(byteOutput);
				objectOutput.writeObject(inputMap);
				objectOutput.close();
				contentData = new ContentData();
				contentData.setContent(byteOutput.toByteArray());
				contentData.setAccessType(AccessType.Inline);
			}
			startTask(taskId, userName);
			taskClient.complete(taskId,userName,contentData,taskOperationHandler);
			
			logger.debug("Task Completed------->\t"+taskId);
			
		}
		catch(IOException io){
			logger.error(
					" IO Exception occured in FFEHumanTaskServiceImpl.completeTask :",
					io.getMessage());
			throw new GTSException(io.getMessage(), io.getCause());
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in FFEHumanTaskServiceImpl.completeTask :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into FFEHumanTaskServiceImpl.completeTask");
	}

	@Override
	public void failTask(Long taskId,String userName,Map<String, Object> inputMap) throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into FFEHumanTaskServiceImpl.failTask");
		
		try{
			logger.debug("Rejecting the Task---------->\t"+taskId);
			ContentData contentData = null;
			if(inputMap != null)
			{
				ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
				ObjectOutputStream objectOutput = null;
				objectOutput = new ObjectOutputStream(byteOutput);
				objectOutput.writeObject(inputMap);
				objectOutput.close();
				contentData = new ContentData();
				contentData.setContent(byteOutput.toByteArray());
				contentData.setAccessType(AccessType.Inline);
				
			}
			startTask(taskId, userName);
			taskClient.complete(taskId,userName,contentData,taskOperationHandler);
			logger.debug("Task Rejected------->\t"+taskId);
			
		}
		catch(IOException io){
			logger.error(
					" IO Exception occured in FFEHumanTaskServiceImpl.failTask :",
					io.getMessage());
			throw new GTSException(io.getMessage(), io.getCause());
		}
		catch(Exception ex)
		{
			logger.error(
					" Exception occured in FFEHumanTaskServiceImpl.failTask :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into FFEHumanTaskServiceImpl.failTask");
	}
	@Override
	public HashMap<String,Object> getTaskData(Long taskId) throws GTSException {
		// TODO Auto-generated method stub
		logger.debug("Entering into FFEHumanTaskServiceImpl.getTask");
		Task task = null;
		HashMap<String,Object> contentMap;
		try{
			logger.debug("Entering into FFEHumanTaskServiceImpl.getTask");
			taskClient.getTask(taskId, taskResponseHandler);
			task = taskResponseHandler.getTask();
			TaskData taskData = task.getTaskData();
			taskClient.getContent(taskData.getDocumentContentId(), taskContentResponseHandler);
			Content content = taskContentResponseHandler.getContent();
			ByteArrayInputStream byteArrayInput = new ByteArrayInputStream(content.getContent());
			ObjectInputStream objectInput = new ObjectInputStream(byteArrayInput);
			Object object = null;
			object = objectInput.readObject();
			contentMap = (HashMap<String,Object>)object;
		}
		catch(IOException io){
			logger.error(
					"IO Exception occured in FFEHumanTaskServiceImpl.getTask :",
					io.getMessage());
			throw new GTSException(io.getMessage(), io.getCause());
		}
		catch(Exception ex){
			logger.error(
					" Exception occured in FFEHumanTaskServiceImpl.getTask :",
					ex.getMessage());
			throw new GTSException(ex.getMessage(), ex.getCause());
		}
		logger.debug("Exiting into FFEHumanTaskServiceImpl.getTask");
		return contentMap;
		
	}
}
