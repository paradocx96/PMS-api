package com.csse.pms.dal.model.inventory;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CountableItemsModel {
	
	@Id
	private String id;
	private String name;
	private String type;
	private int quantity;
	private int minimumQuantity;
	private String siteid;
	private String sitename;
	
	public CountableItemsModel() {
		
	}


	





	public CountableItemsModel(String id, String name, String type, int quantity, int minimumQuantity, String siteid,
			String sitename) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.minimumQuantity = minimumQuantity;
		this.siteid = siteid;
		this.sitename = sitename;
	}








	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getMinimumQuantity() {
		return minimumQuantity;
	}


	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}


	public String getSiteid() {
		return siteid;
	}


	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}


	public String getSitename() {
		return sitename;
	}


	public void setSitename(String sitename) {
		this.sitename = sitename;
	}








	public String getType() {
		return type;
	}








	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	
	
	
	
	
}
