package adins.ace.taps.form.manageRole;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import adins.ace.taps.bean.manageRole.EmployeeBean;
import adins.ace.taps.bean.manageRole.EmployeeRoleBean;
import adins.ace.taps.bean.manageRole.MenuBean;
import adins.ace.taps.bean.manageRole.RoleBean;



@SuppressWarnings("serial")
public class ManageRoleForm extends ActionForm {
	
	private String task;
	private String param;
	private String mode;
	private String message;
	private String messagecolor;
	private String roleId;
	private String roleName;
	private String searchKeyword;
	private String searchCategory;
	private Integer page;
	private Integer maxpage;
	private Integer countRecord;
	private String searchKeywordER;
	private String searchCategoryER;
	private Integer pageER;
	private Integer maxpageER;
	private Integer countRecordER;
	private List<MenuBean> listMenu;
	private List<RoleBean> listRole;
	private List<MenuBean> listMenuByRole;
	private List<EmployeeBean> listMember;
	private List<EmployeeRoleBean> listEmployeeRole;
	private MenuBean mrBean = new MenuBean();
	private RoleBean rBean = new RoleBean();
	
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
	public String getSearchKeywordER() {
		return searchKeywordER;
	}
	public void setSearchKeywordER(String searchKeywordER) {
		this.searchKeywordER = searchKeywordER;
	}
	public String getSearchCategoryER() {
		return searchCategoryER;
	}
	public void setSearchCategoryER(String searchCategoryER) {
		this.searchCategoryER = searchCategoryER;
	}
	public Integer getPageER() {
		return pageER;
	}
	public void setPageER(Integer pageER) {
		this.pageER = pageER;
	}
	public Integer getMaxpageER() {
		return maxpageER;
	}
	public void setMaxpageER(Integer maxpageER) {
		this.maxpageER = maxpageER;
	}
	public Integer getCountRecordER() {
		return countRecordER;
	}
	public void setCountRecordER(Integer countRecordER) {
		this.countRecordER = countRecordER;
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
	public RoleBean getrBean() {
		return rBean;
	}
	public void setrBean(RoleBean rBean) {
		this.rBean = rBean;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public List<MenuBean> getListMenuByRole() {
		return listMenuByRole;
	}
	public void setListMenuByRole(List<MenuBean> listMenuByRole) {
		this.listMenuByRole = listMenuByRole;
	}
	public List<EmployeeBean> getListMember() {
		return listMember;
	}
	public void setListMember(List<EmployeeBean> listMember) {
		this.listMember = listMember;
	}
	public List<EmployeeRoleBean> getListEmployeeRole() {
		return listEmployeeRole;
	}
	public void setListEmployeeRole(List<EmployeeRoleBean> listEmployeeRole) {
		this.listEmployeeRole = listEmployeeRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessagecolor() {
		return messagecolor;
	}
	public void setMessagecolor(String messagecolor) {
		this.messagecolor = messagecolor;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
