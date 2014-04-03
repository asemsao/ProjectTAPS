package adins.ace.taps.bean.organization;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrganizationBean implements Serializable {
	private String organizationCode;
	private String organizationName;
	private String headName;
	private String headDomain;
	private String memberDomain;
	private String memberName;
	private String memberCode;
	private Integer organizationLevel;
	private String parentCode;
	private String parentName;
	private String flag;
	private String createdBy;
	private String createdDate;
	private String updateBy;
	private String updateDate;
	private String sessionUserDomain;
	private String projectCode;
	private String projectName;
	private Integer organizationLevelChild;

	public Integer getOrganizationLevelChild() {
		return organizationLevelChild;
	}

	public void setOrganizationLevelChild(Integer organizationLevelChild) {
		this.organizationLevelChild = organizationLevelChild;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

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

	public String getMemberDomain() {
		return memberDomain;
	}

	public void setMemberDomain(String memberDomain) {
		this.memberDomain = memberDomain;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
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
