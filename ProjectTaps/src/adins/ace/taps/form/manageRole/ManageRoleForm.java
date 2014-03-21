package adins.ace.taps.form.manageRole;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import adins.ace.taps.bean.manageRole.MenuBean;
import adins.ace.taps.bean.manageRole.RoleBean;



@SuppressWarnings("serial")
public class ManageRoleForm extends ActionForm {
	
	private String task;
	private String param;
	private String searchKeyword;
	private String searchCategory;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private List<MenuBean> listMenu;
	private List<RoleBean> listRole;
	private MenuBean mrBean = new MenuBean();
	private MenuBean rBean = new MenuBean();
	
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
	public List<MenuBean> getListMenu() {
		return listMenu;
	}
	public void setListMenu(List<MenuBean> listMenu) {
		this.listMenu = listMenu;
	}
	public List<RoleBean> getListRole() {
		return listRole;
	}
	public void setListRole(List<RoleBean> listRole) {
		this.listRole = listRole;
	}
	public MenuBean getMrBean() {
		return mrBean;
	}
	public void setMrBean(MenuBean mrBean) {
		this.mrBean = mrBean;
	}
	public MenuBean getrBean() {
		return rBean;
	}
	public void setrBean(MenuBean rBean) {
		this.rBean = rBean;
	}
	
}
