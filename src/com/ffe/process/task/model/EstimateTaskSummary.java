package com.ffe.process.task.model;

import java.io.Serializable;

import org.jbpm.task.query.TaskSummary;

import com.ffe.estimate.model.Estimate;

public class EstimateTaskSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1378456440493689784L;
	private Estimate estimate = new Estimate();
	private TaskSummary taskSummary = new TaskSummary();
	public TaskSummary getTaskSummary() {
		return taskSummary;
	}
	public void setTaskSummary(TaskSummary taskSummary) {
		this.taskSummary = taskSummary;
	}
	public Estimate getEstimate() {
		return estimate;
	}
	public void setEstimate(Estimate estimate) {
		this.estimate = estimate;
	}


	
}
