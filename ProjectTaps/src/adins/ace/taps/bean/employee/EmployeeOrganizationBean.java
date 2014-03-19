package adins.ace.taps.bean.employee;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeOrganizationBean implements Serializable {
	private String organizationCode;
	private String organizationName;
	private String headUserDomain;
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getHeadUserDomain() {
		return headUserDomain;
	}
	public void setHeadUserDomain(String headUserDomain) {
		this.headUserDomain = headUserDomain;
	}

}
