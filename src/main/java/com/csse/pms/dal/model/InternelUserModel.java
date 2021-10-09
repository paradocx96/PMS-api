package com.csse.pms.dal.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InternelUserModel {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String contactNo;
	private String address;
	private String userType;
	
	@DBRef
	private Set<Role> roles = new HashSet<>();
	
	
	public InternelUserModel() {
		
	}

	public InternelUserModel(String name,String email,String password,String contactNo, String address) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
	}

	 @Override
	public String toString() {
		return "Supplier-Model{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contacNo='" + contactNo + '\'' +
                ", address=" + address +
                '}';
		
	}
	
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
