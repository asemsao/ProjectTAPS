package adins.ace.taps.form.assignment;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.NewSelfAssignmentBean;

@SuppressWarnings("serial")
public class NewSelfAssignmentForm extends ActionForm {
	private NewSelfAssignmentBean selfAssignBean = new NewSelfAssignmentBean();
	private String newTask;
	private String assignmentType;
	private String activityType;

	public NewSelfAssignmentBean getSelfAssignBean() {
		return selfAssignBean;
	}

	public void setSelfAssignBean(NewSelfAssignmentBean selfAssignBean) {
		this.selfAssignBean = selfAssignBean;
	}

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

}
