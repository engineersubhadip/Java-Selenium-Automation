package Pojo;

public class SingleUser {

	private String emailAddress;
	private String password;
	private String status;

	public SingleUser(String emailAddress, String password, String status) {
		this.emailAddress = emailAddress;
		this.password = password;
		this.status = status;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
