package com.csse.pms.domain.inventory;

import java.util.List;

import com.csse.pms.dal.model.inventory.CountableItemsModel;

public interface CountableItemsDataAdpater {
	
	public List<CountableItemsModel> getAll();
	public String addItem(CountableItemsModel newItem);
	public CountableItemsModel getItemById(String id);
	public List<CountableItemsModel>   getItemByName(String name);
	public List<CountableItemsModel> getItemsByType(String type);
	public String updateItem(CountableItemsModel updatedItem);
	public String deleteItem(String id);
	public String updateQuantity(int quantity, String id);
	public List<CountableItemsModel> getItemsBySiteId(String siteId);

}
