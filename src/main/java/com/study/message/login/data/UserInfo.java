package com.study.message.login.data;

public class UserInfo {
	private Long id;
	
	private String userName;

	private String password;

	private String level;

	private Boolean remeberMe;

	public Boolean getRemeberMe() {
		return remeberMe;
	}

	public void setRemeberMe(Boolean remeberMe) {
		this.remeberMe = remeberMe;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
