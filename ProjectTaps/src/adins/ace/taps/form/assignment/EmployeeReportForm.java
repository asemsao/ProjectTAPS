package adins.ace.taps.form.assignment;

import java.util.List;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class EmployeeReportForm extends ActionForm {
	private List listAssignment;
	private String task;
	private String taskCode;
	private String currentStatus;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private String category;
	private String keyword;
	private String startDate;
	private String endDate;

	public List getListAssignment() {
		return listAssignment;
	}

	public void setListAssignment(List listAssignment) {
		this.listAssignment = listAssignment;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(Integer maxpage) {
		this.maxpage = maxpage;
	}

	public Integer getCountRecord() {
		return countRecord;
	}

	public void setCountRecord(Integer countRecord) {
		this.countRecord = countRecord;
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

}