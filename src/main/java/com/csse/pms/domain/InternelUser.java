package com.csse.pms.domain;

public class InternelUser {
	
	private String id;
	private String name;
	private String email;
	private String password;
	private String contactNo;
	private String address;
	private String userType;

	
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public String getContactNo() {
		return contactNo;
	}


	public String getAddress() {
		return address;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}

}
