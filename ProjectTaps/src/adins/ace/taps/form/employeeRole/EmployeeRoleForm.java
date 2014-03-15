package adins.ace.taps.form.employeeRole;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import adins.ace.taps.bean.employeeRole.EmployeeRoleBean;

@SuppressWarnings("serial")
public class EmployeeRoleForm extends ActionForm {
	
	private String task;
	private String param;
	private String searchKeyword;
	private String searchCategory;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private List<EmployeeRoleBean> listEmployeeRole;
	private EmployeeRoleBean erBean = new EmployeeRoleBean();
	
	public EmployeeRoleBean getErBean() {
		return erBean;
	}
	public void setErBean(EmployeeRoleBean erBean) {
		this.erBean = erBean;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchCategory() {
		return searchCategory;
	}
	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
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
	public List<EmployeeRoleBean> getListEmployeeRole() {
		return listEmployeeRole;
	}
	public void setListEmployeeRole(List<EmployeeRoleBean> listEmployeeRole) {
		this.listEmployeeRole = listEmployeeRole;
	}
	
}
