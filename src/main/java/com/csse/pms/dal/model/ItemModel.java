package com.csse.pms.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ItemModel {

	@Id
	private String id;
	private String supplierID;
	private String name;
	private String quantity;
	private double price;
	
	public ItemModel(){
		
	}
	 
	public ItemModel(String supplierID, String name,String quantity,double price){
		this.supplierID = supplierID;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
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
