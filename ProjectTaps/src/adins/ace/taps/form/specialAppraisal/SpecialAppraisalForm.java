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
	private String searchDate;
	private SpecialAppraisalBean appraisalBean = new SpecialAppraisalBean();

	
	
	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
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
	
}