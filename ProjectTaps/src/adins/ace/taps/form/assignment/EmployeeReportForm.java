package adins.ace.taps.form.assignment;

import java.util.List;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class EmployeeReportForm extends ActionForm {
	private List listAssignment;
	private String task;
	private String param;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private String search;
	private String value;
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

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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