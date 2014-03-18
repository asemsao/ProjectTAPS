package adins.ace.taps.form.dashboard;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.assignment.ClaimAssignmentBean;
import adins.ace.taps.bean.assignment.NewAssignmentBean;
import adins.ace.taps.bean.dashboard.DashboardBean;

@SuppressWarnings("serial")
public class DashboardForm extends ActionForm {
	DashboardBean dBean = new DashboardBean();
	ClaimAssignmentBean claimBean = new ClaimAssignmentBean();
	NewAssignmentBean selfAssignBean = new NewAssignmentBean();
	private String task;
	private String employeeDomain;
	private List<DashboardBean> listTopTen;
	private List<DashboardBean> listTopTenOrganization;
	private Integer page;
	private Integer maxPage;
	private List<ClaimAssignmentBean> listAssignment;
	private List<NewAssignmentBean> listSelfAssignment;
	private List<ClaimAssignmentBean> listDetailClaim;
	private String totalManHours;
	private Integer totalClaim;
	private Integer totalCorrection;
	private Integer totalCorrectionSelf;
	private Integer totalRFA;
	private Integer totalRFAself;
	private String startDate;
	private String endDate;
	private String category;
	private String keyword;
	private Integer countRecord;
	private String taskCode;
	private String taskType;
	private String currentStatus;

	public NewAssignmentBean getSelfAssignBean() {
		return selfAssignBean;
	}

	public void setSelfAssignBean(NewAssignmentBean selfAssignBean) {
		this.selfAssignBean = selfAssignBean;
	}

	public ClaimAssignmentBean getClaimBean() {
		return claimBean;
	}

	public void setClaimBean(ClaimAssignmentBean claimBean) {
		this.claimBean = claimBean;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Integer getCountRecord() {
		return countRecord;
	}

	public void setCountRecord(Integer countRecord) {
		this.countRecord = countRecord;
	}

	public DashboardBean getdBean() {
		return dBean;
	}

	public void setdBean(DashboardBean dBean) {
		this.dBean = dBean;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public List<DashboardBean> getListTopTen() {
		return listTopTen;
	}

	public void setListTopTen(List<DashboardBean> listTopTen) {
		this.listTopTen = listTopTen;
	}

	public List<DashboardBean> getListTopTenOrganization() {
		return listTopTenOrganization;
	}

	public List<ClaimAssignmentBean> getListDetailClaim() {
		return listDetailClaim;
	}

	public void setListDetailClaim(List<ClaimAssignmentBean> listDetailClaim) {
		this.listDetailClaim = listDetailClaim;
	}

	public String getTotalManHours() {
		return totalManHours;
	}

	public void setTotalManHours(String totalManHours) {
		this.totalManHours = totalManHours;
	}

	public void setListTopTenOrganization(
			List<DashboardBean> listTopTenOrganization) {
		this.listTopTenOrganization = listTopTenOrganization;
	}

	public String getEmployeeDomain() {
		return employeeDomain;
	}

	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public List<ClaimAssignmentBean> getListAssignment() {
		return listAssignment;
	}

	public void setListAssignment(List<ClaimAssignmentBean> listAssignment) {
		this.listAssignment = listAssignment;
	}

	public List<NewAssignmentBean> getListSelfAssignment() {
		return listSelfAssignment;
	}

	public void setListSelfAssignment(List<NewAssignmentBean> listSelfAssignment) {
		this.listSelfAssignment = listSelfAssignment;
	}

	public Integer getTotalClaim() {
		return totalClaim;
	}

	public void setTotalClaim(Integer totalClaim) {
		this.totalClaim = totalClaim;
	}

	public Integer getTotalCorrection() {
		return totalCorrection;
	}

	public void setTotalCorrection(Integer totalCorrection) {
		this.totalCorrection = totalCorrection;
	}

	public Integer getTotalCorrectionSelf() {
		return totalCorrectionSelf;
	}

	public void setTotalCorrectionSelf(Integer totalCorrectionSelf) {
		this.totalCorrectionSelf = totalCorrectionSelf;
	}

	public Integer getTotalRFA() {
		return totalRFA;
	}

	public void setTotalRFA(Integer totalRFA) {
		this.totalRFA = totalRFA;
	}

	public Integer getTotalRFAself() {
		return totalRFAself;
	}

	public void setTotalRFAself(Integer totalRFAself) {
		this.totalRFAself = totalRFAself;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
