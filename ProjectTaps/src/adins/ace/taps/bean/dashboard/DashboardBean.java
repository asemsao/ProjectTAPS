package adins.ace.taps.bean.dashboard;

public class DashboardBean {
	private String userName;
	private String employeeName;
	private String totalStar;
	private Integer claimEmployee;
	private Integer correctionEmployee;
	private Integer claimSupervisor;
	private Integer correctionSupervisor;
	private Integer rfaSupervisor;
	private byte[] profilePicture;
	private String userDomain;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTotalStar() {
		return totalStar;
	}

	public void setTotalStar(String totalStar) {
		this.totalStar = totalStar;
	}

	public Integer getClaimEmployee() {
		return claimEmployee;
	}

	public void setClaimEmployee(Integer claimEmployee) {
		this.claimEmployee = claimEmployee;
	}

	public Integer getCorrectionEmployee() {
		return correctionEmployee;
	}

	public void setCorrectionEmployee(Integer correctionEmployee) {
		this.correctionEmployee = correctionEmployee;
	}

	public Integer getClaimSupervisor() {
		return claimSupervisor;
	}

	public void setClaimSupervisor(Integer claimSupervisor) {
		this.claimSupervisor = claimSupervisor;
	}

	public Integer getCorrectionSupervisor() {
		return correctionSupervisor;
	}

	public void setCorrectionSupervisor(Integer correctionSupervisor) {
		this.correctionSupervisor = correctionSupervisor;
	}

	public Integer getRfaSupervisor() {
		return rfaSupervisor;
	}

	public void setRfaSupervisor(Integer rfaSupervisor) {
		this.rfaSupervisor = rfaSupervisor;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getUserDomain() {
		return userDomain;
	}

	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}

}
