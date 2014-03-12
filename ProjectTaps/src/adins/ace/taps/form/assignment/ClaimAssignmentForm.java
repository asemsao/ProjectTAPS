package adins.ace.taps.form.assignment;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;

@SuppressWarnings("serial")
public class ClaimAssignmentForm extends ActionForm {
	private String task;
	private ClaimAssignmentBean claimBean = new ClaimAssignmentBean();
	private List listDetailClaim;
	private List historyComment;
	private String totalManhours;

	public String getTotalManhours() {
		return totalManhours;
	}

	public void setTotalManhours(String totalManhours) {
		this.totalManhours = totalManhours;
	}

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

}
