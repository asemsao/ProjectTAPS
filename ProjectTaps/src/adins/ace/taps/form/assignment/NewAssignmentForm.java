package adins.ace.taps.form.assignment;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.NewAssignmentBean;

@SuppressWarnings("serial")
public class NewAssignmentForm extends ActionForm {
	private NewAssignmentBean assignmentBean = new NewAssignmentBean();
	private String newTask;
	private String assignmentType;

	public NewAssignmentBean getAssignmentBean() {
		return assignmentBean;
	}

	public void setAssignmentBean(NewAssignmentBean assignmentBean) {
		this.assignmentBean = assignmentBean;
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

}