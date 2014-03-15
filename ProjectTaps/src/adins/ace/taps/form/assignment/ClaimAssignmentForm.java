package adins.ace.taps.form.assignment;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.bean.assignment.NewAssignmentBean;

@SuppressWarnings("serial")
public class ClaimAssignmentForm extends ActionForm {
	private String task;
	private ClaimAssignmentBean claimBean = new ClaimAssignmentBean();
	private List listDetailClaim;
	private List historyComment;
	private String totalManhours;
	private String newTask;
	private ClaimAssignmentBean assignmentBean = new ClaimAssignmentBean();
	private String assignmentType;
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public ClaimAssignmentBean getClaimBean() {
		return claimBean;
	}
	public void setClaimBean(ClaimAssignmentBean claimBean) {
		this.claimBean = claimBean;
	}
	public List getListDetailClaim() {
		return listDetailClaim;
	}
	public void setListDetailClaim(List listDetailClaim) {
		this.listDetailClaim = listDetailClaim;
	}
	public List getHistoryComment() {
		return historyComment;
	}
	public void setHistoryComment(List historyComment) {
		this.historyComment = historyComment;
	}
	public String getTotalManhours() {
		return totalManhours;
	}
	public void setTotalManhours(String totalManhours) {
		this.totalManhours = totalManhours;
	}
	public String getNewTask() {
		return newTask;
	}
	public void setNewTask(String newTask) {
		this.newTask = newTask;
	}
	public ClaimAssignmentBean getAssignmentBean() {
		return assignmentBean;
	}
	public void setAssignmentBean(ClaimAssignmentBean assignmentBean) {
		this.assignmentBean = assignmentBean;
	}
	public String getAssignmentType() {
		return assignmentType;
	}
	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}
	
}
