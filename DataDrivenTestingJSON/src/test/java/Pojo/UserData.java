package Pojo;

import java.util.List;

public class UserData {

	private List<SingleUser> data;

	public UserData(List<SingleUser> data) {
		setData(data);
	}

	public List<SingleUser> getData() {
		return data;
	}

	public void setData(List<SingleUser> data) {
		this.data = data;
	}
}
