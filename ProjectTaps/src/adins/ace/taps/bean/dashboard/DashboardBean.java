package adins.ace.taps.bean.dashboard;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DashboardBean implements Serializable {
	private String userName;
	private String employeeName;
	private String totalStar;
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
