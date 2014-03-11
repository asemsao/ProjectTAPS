package adins.ace.taps.form.specialAppraisal;

import java.util.List;

import org.apache.struts.action.ActionForm;

import adins.ace.taps.bean.specialAppraisal.SpecialAppraisalBean;

@SuppressWarnings("serial")
public class SpecialAppraisalForm extends ActionForm {
	private String task;
	private String search;
	private String value;
	private List<SpecialAppraisalBean> listSpecialAppraisal;
	private Integer page;
	private Integer maxpage;
	private String param;

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
}