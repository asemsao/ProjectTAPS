package adins.ace.taps.bean.employee;

import java.io.Serializable;

import org.apache.struts.upload.FormFile;

public class NewEmployeeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String task;
	private String employeeDomain;
	private String employeeNik;
	private String employeeCode;
	private String firstName;
	private String lastName;
	private String gender;
	private String businessUnit;
	private String businessUnitName;
	private String employeeAddress;
	private String phoneNumber;
	private String phoneNumberAreaCode;
	private String phoneNumberMidNumb;
	private String phoneNumberLastNumb;
	private String mobileNumber;
	private String mobileNumberAreaCode;
	private String mobileNumberMidNumb;
	private String mobileNumberLastNumb;
	private String email;
	private String golonganNumber;
	private String golonganLevel;
	private byte[] profilePicture;
	private String flag;
	private String createBy;
	private String createDate;
	private String updateBy;
	private String updateDate;
	private FormFile tempProfPic;
	public String getPhoneNumberAreaCode() {
		return phoneNumberAreaCode;
	}
	public void setPhoneNumberAreaCode(String phoneNumberAreaCode) {
		this.phoneNumberAreaCode = phoneNumberAreaCode;
	}
	public String getPhoneNumberMidNumb() {
		return phoneNumberMidNumb;
	}
	public void setPhoneNumberMidNumb(String phoneNumberMidNumb) {
		this.phoneNumberMidNumb = phoneNumberMidNumb;
	}
	public String getPhoneNumberLastNumb() {
		return phoneNumberLastNumb;
	}
	public void setPhoneNumberLastNumb(String phoneNumberLastNumb) {
		this.phoneNumberLastNumb = phoneNumberLastNumb;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getEmployeeDomain() {
		return employeeDomain;
	}
	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}
	public String getEmployeeNik() {
		return employeeNik;
	}
	public void setEmployeeNik(String employeeNik) {
		this.employeeNik = employeeNik;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
	public String getGolonganNumber() {
		return golonganNumber;
	}
	public void setGolonganNumber(String golonganNumber) {
		this.golonganNumber = golonganNumber;
	}
	public String getGolonganLevel() {
		return golonganLevel;
	}
	public void setGolonganLevel(String golonganLevel) {
		this.golonganLevel = golonganLevel;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	public FormFile getTempProfPic() {
		return tempProfPic;
	}
	public void setTempProfPic(FormFile tempProfPic) {
		this.tempProfPic = tempProfPic;
	}
	public String getBusinessUnitName() {
		return businessUnitName;
	}
	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}
	public String getMobileNumberAreaCode() {
		return mobileNumberAreaCode;
	}
	public void setMobileNumberAreaCode(String mobileNumberAreaCode) {
		this.mobileNumberAreaCode = mobileNumberAreaCode;
	}
	public String getMobileNumberMidNumb() {
		return mobileNumberMidNumb;
	}
	public void setMobileNumberMidNumb(String mobileNumberMidNumb) {
		this.mobileNumberMidNumb = mobileNumberMidNumb;
	}
	public String getMobileNumberLastNumb() {
		return mobileNumberLastNumb;
	}
	public void setMobileNumberLastNumb(String mobileNumberLastNumb) {
		this.mobileNumberLastNumb = mobileNumberLastNumb;
	}
}
