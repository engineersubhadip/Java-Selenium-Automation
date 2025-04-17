package Pojo;

public class SingleUser {
	
	private String userName;
	private String userPassword;
	private String userStatus;
	
	public SingleUser(String userName, String userPassword, String userStatus) {
		setUserName(userName);
		setUserPassword(userPassword);
		setUserStatus(userStatus);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
