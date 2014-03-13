package adins.ace.taps.bean.project;

import java.io.Serializable;

public class AddStructureProjectBean implements Serializable 
{
	private String projectCode;
	private String projectRole;
	private String assigneeUserDomain;
	private String directreportUserDomain;
	private String flag;
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectRole() {
		return projectRole;
	}
	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}
	
	public String getAssigneeUserDomain() {
		return assigneeUserDomain;
	}
	public void setAssigneeUserDomain(String assigneeUserDomain) {
		this.assigneeUserDomain = assigneeUserDomain;
	}
	public String getDirectreportUserDomain() {
		return directreportUserDomain;
	}
	public void setDirectreportUserDomain(String directreportUserDomain) {
		this.directreportUserDomain = directreportUserDomain;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
