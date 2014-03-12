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

	public List<ClaimAssignmentBean> getListDetailClaim() {
		return listDetailClaim;
	}

	public void setListDetailClaim(List<ClaimAssignmentBean> listDetailClaim) {
		this.listDetailClaim = listDetailClaim;
	}

	public List<ClaimAssignmentBean> getHistoryComment() {
		return historyComment;
	}

	public void setHistoryComment(List<ClaimAssignmentBean> historyComment) {
		this.historyComment = historyComment;
	}

}
