package adins.ace.taps.bean.project;

import java.io.Serializable;

public class AddStructureProjectBean implements Serializable 
{
	private String projectCode;
	private String projectRole;
	private String assigneeEmployeeNik;
	private String directreportEmployeeNik;
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
	public String getAssigneeEmployeeNik() {
		return assigneeEmployeeNik;
	}
	public void setAssigneeEmployeeNik(String assigneeEmployeeNik) {
		this.assigneeEmployeeNik = assigneeEmployeeNik;
	}
	public String getDirectreportEmployeeNik() {
		return directreportEmployeeNik;
	}
	public void setDirectreportEmployeeNik(String directreportEmployeeNik) {
		this.directreportEmployeeNik = directreportEmployeeNik;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
