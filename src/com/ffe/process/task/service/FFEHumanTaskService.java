package com.ffe.process.task.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.task.Task;
import org.jbpm.task.query.TaskSummary;

import com.ffe.common.exception.GTSException;

public interface FFEHumanTaskService {
	public List<TaskSummary> lstTaskAssginedtoUser(String userName,String language) throws GTSException;
	public List<TaskSummary> lstTaskAssginedtoGroup(String groupNam,String languagee) throws GTSException;
	public void claimTask(Long taskId,String userName)throws GTSException;
	public void startTask(Long taskId,String userName)throws GTSException;
	public void stopTask(Long taskId,String userName)throws GTSException;
	public void completeTask(Long taskId,String userName,Map<String,Object> inputMap) throws GTSException;
	public void failTask(Long taskId,String userName,Map<String,Object> inputMap) throws GTSException;
	public HashMap<String,Object> getTaskData(Long taskId) throws GTSException;
}
