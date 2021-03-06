package adins.ace.taps.form.specialAppraisal;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.specialAppraisal.SpecialAppraisalBean;

@SuppressWarnings("serial")
public class SpecialAppraisalForm extends ActionForm {
	private String task;
	private List<SpecialAppraisalBean> listSpecialAppraisal;
	private Integer page;
	private Integer maxpage;
	private String param;
	private String searchCategory;
	private String searchKeyword;
	private String startDate;
	private String endDate;
	private String message;
	private String color;
	private SpecialAppraisalBean appraisalBean = new SpecialAppraisalBean();

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

	public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public SpecialAppraisalBean getAppraisalBean() {
		return appraisalBean;
	}

	public void setAppraisalBean(SpecialAppraisalBean appraisalBean) {
		this.appraisalBean = appraisalBean;
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

	private Integer countRecord;

	public List<SpecialAppraisalBean> getListSpecialAppraisal() {
		return listSpecialAppraisal;
	}

	public void setListSpecialAppraisal(
			List<SpecialAppraisalBean> listSpecialAppraisal) {
		this.listSpecialAppraisal = listSpecialAppraisal;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}