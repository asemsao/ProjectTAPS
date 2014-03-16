package adins.ace.taps.form.assignment;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.bean.assignment.NewAssignmentBean;

@SuppressWarnings("serial")
public class SelfAssignmentForm extends ActionForm {
	private String task;
	private NewAssignmentBean selfAssignBean = new NewAssignmentBean();
	private List historyComment;
	private String newTask;
	private String assignmentType;
	private String activityType;
	
	public String getNewTask() {
		return newTask;
	}

	public void setNewTask(String newTask) {
		this.newTask = newTask;
	}

	public String getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	public List getHistoryComment() {
		return historyComment;
	}

	public void setHistoryComment(List historyComment) {
		this.historyComment = historyComment;
	}

	public NewAssignmentBean getSelfAssignBean() {
		return selfAssignBean;
	}

	public void setSelfAssignBean(NewAssignmentBean selfAssignBean) {
		this.selfAssignBean = selfAssignBean;
	}
}
