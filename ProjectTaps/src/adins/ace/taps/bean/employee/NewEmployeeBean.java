package adins.ace.taps.bean.employee;

import java.io.Serializable;

import org.apache.struts.upload.FormFile;

public class NewEmployeeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String employeeDomain;
	private String employeeCode;
	private String employeeNik;
	private String firstName;
	private String lastName;
	private String gender;
	private String businessUnit;
	private String employeeAddress;
	private String phoneNumber;
	private String mobileNumber;
	private String email;
	private String golongan;
	private FormFile profilePicture;
	public String getEmployeeDomain() {
		return employeeDomain;
	}
	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeNik() {
		return employeeNik;
	}
	public void setEmployeeNik(String employeeNik) {
		this.employeeNik = employeeNik;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGolongan() {
		return golongan;
	}
	public void setGolongan(String golongan) {
		this.golongan = golongan;
	}
	public FormFile getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(FormFile profilePicture) {
		this.profilePicture = profilePicture;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
