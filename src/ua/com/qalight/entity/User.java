package ua.com.qalight.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{

	private String userName;
	
	private String userSurname;
	
	private Integer age;
	
	private int userId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public static void showClassName() {		
		System.out.println(User.class.getSimpleName());
	}
	
	@Override
	public String toString() {
		return userName + " " + userSurname;
	}
}
