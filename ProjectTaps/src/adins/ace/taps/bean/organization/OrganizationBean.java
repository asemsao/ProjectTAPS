package adins.ace.taps.bean.organization;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrganizationBean implements Serializable {
	private String organizationCode;
	private String organizationName;
	private String headName;
	private String headDomain;
	private Integer organizationLevel;
	private String parentCode;
	private String flag;
	private String createdBy;
	private String createdDate;
	private String updateBy;
	private String updateDate;
	private String sessionUserDomain;

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

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getHeadDomain() {
		return headDomain;
	}

	public void setHeadDomain(String headDomain) {
		this.headDomain = headDomain;
	}

	public Integer getOrganizationLevel() {
		return organizationLevel;
	}

	public void setOrganizationLevel(Integer organizationLevel) {
		this.organizationLevel = organizationLevel;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getSessionUserDomain() {
		return sessionUserDomain;
	}

	public void setSessionUserDomain(String sessionUserDomain) {
		this.sessionUserDomain = sessionUserDomain;
	}

}
