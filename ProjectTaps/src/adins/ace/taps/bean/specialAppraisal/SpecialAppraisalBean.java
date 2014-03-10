package adins.ace.taps.bean.specialAppraisal;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SpecialAppraisalBean implements Serializable{
	private Integer starId;
	private Integer starAfter;
	private Integer starBefore;
	private Integer appraisalStar;
	
	private String createdBy;
	private String createdDate;
	private String userDomain;
	private String description;
	private String employeeName;
	private String firstName;
	private String lastName;
	private String sessionUserDomain;
	
	

	public Integer getStarId() {
		return starId;
	}
	public void setStarId(Integer starId) {
		this.starId = starId;
	}
	public Integer getStarAfter() {
		return starAfter;
	}
	public void setStarAfter(Integer starAfter) {
		this.starAfter = starAfter;
	}
	public Integer getStarBefore() {
		return starBefore;
	}
	public void setStarBefore(Integer starBefore) {
		this.starBefore = starBefore;
	}
	public Integer getAppraisalStar() {
		return appraisalStar;
	}
	public void setAppraisalStar(Integer appraisalStar) {
		this.appraisalStar = appraisalStar;
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
	public String getUserDomain() {
		return userDomain;
	}
	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSessionUserDomain() {
		return sessionUserDomain;
	}
	public void setSessionUserDomain(String sessionUserDomain) {
		this.sessionUserDomain = sessionUserDomain;
	}
	
}

