package com.csse.pms.domain;

public class Item {
	
	private String id;
	private String supplierID;
	private String name;
	private String quantity;
	private double price;

	
	public String getId() {
		return id;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public String getName() {
		return name;
	}
	public String getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	

}
