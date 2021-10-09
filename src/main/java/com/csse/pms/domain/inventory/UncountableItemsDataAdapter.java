package com.csse.pms.domain.inventory;

import java.util.List;

import com.csse.pms.dal.model.inventory.UncountableItemsModel;

public interface UncountableItemsDataAdapter {
	
	public List<UncountableItemsModel> getAll();
	public String addItem(UncountableItemsModel newItem);
	public UncountableItemsModel getItemById(String id);
	public UncountableItemsModel getItemByName(String name);
	public List<UncountableItemsModel> getItemsByType(String type);
	public String updateItem(UncountableItemsModel updatedItem);
	public String deleteItem(String id);
	public String updateAmount(double amount, String id);
	public List<UncountableItemsModel> getItemsBySiteId(String siteId);

}
