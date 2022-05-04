package com.mycompany.myapp.vo;

import java.sql.Date;

public class UserVO {
	private String userId;
	private String userPassword;
	private String userName;
	private Date userBirth;
	private String userAddress;
	private String userPhone;
	private Date userSignup;
	private String userIsAdmin;
	
	public UserVO() {
		super();
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getUserSignup() {
		return userSignup;
	}

	public void setUserSignup(Date userSignup) {
		this.userSignup = userSignup;
	}

	public String getUserIsAdmin() {
		return userIsAdmin;
	}

	public void setUserIsAdmin(String userIsAdmin) {
		this.userIsAdmin = userIsAdmin;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", userBirth=" + userBirth + ", userAddress=" + userAddress + ", userPhone=" + userPhone
				+ ", userSignup=" + userSignup + ", userIsAdmin=" + userIsAdmin + "]";
	}
	
	
}
