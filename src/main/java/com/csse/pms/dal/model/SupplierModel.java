package com.csse.pms.dal.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SupplierModel {

	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String contactNo;
	private String address;
	private String location;
	private String status;
	
	
	@DBRef
	private Set<Role> roles = new HashSet<>();
	
	
	public SupplierModel() {
		
	}

	public SupplierModel(String name,String email,String password,String contactNo, String address,String location,  String status) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
		this.location = location;
		this.status = status;
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
                ", location='" + location + '\'' +
                ", status=" + status +
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


	public String getLocation() {
		return location;
	}


	public String getStatus() {
		return status;
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


	public void setLocation(String location) {
		this.location = location;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
