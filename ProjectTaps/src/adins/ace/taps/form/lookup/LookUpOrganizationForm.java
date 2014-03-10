package adins.ace.taps.form.lookup;


import org.apache.struts.action.ActionForm;


public class LookUpOrganizationForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String task;
	private String search;
	private String keyword;
	private Integer page;
	private Integer maxpage;
	private String category;
	private Integer countRecord;
	
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getCountRecord() {
		return countRecord;
	}
	public void setCountRecord(Integer countRecord) {
		this.countRecord = countRecord;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
