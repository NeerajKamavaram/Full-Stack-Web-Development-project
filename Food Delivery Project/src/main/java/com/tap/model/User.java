package com.tap.model;

import java.time.LocalDateTime;
public class User 
{
	private int userId;
	private String name;
	private String email;
	private long phone_No;
	private String address;
	private String userName;
	private String passWord;
	private String role;
	
	public User() 
	{
		
	}

	public User(int userId, String name, String email, long phone_No, String address, String userName, String passWord,
			String role, LocalDateTime created_Date, LocalDateTime last_LoginDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone_No = phone_No;
		this.address = address;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(long phone_No) {
		this.phone_No = phone_No;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
    

}
