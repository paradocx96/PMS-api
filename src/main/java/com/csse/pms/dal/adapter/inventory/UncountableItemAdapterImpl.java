package com.csse.pms.dal.adapter.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


import com.csse.pms.dal.model.inventory.UncountableItemsModel;
import com.csse.pms.dal.repository.inventory.UncountableItemRepository;
import com.csse.pms.domain.inventory.UncountableItemsDataAdapter;

@Component
public class UncountableItemAdapterImpl implements UncountableItemsDataAdapter {
	
	private UncountableItemRepository uncountableItemRepository;
	private MongoTemplate mongoTemplate;
	
	@Autowired
	public UncountableItemAdapterImpl(UncountableItemRepository uncountableItemRepository,
			MongoTemplate mongoTemplate) {
		this.uncountableItemRepository = uncountableItemRepository;
		this.mongoTemplate = mongoTemplate;
	}

	//returns all items
	@Override
	public List<UncountableItemsModel> getAll() {
		return uncountableItemRepository.findAll();
	}

	//add a new item
	@Override
	public String addItem(UncountableItemsModel newItem) {
		return uncountableItemRepository.save(newItem).getId();
	}

	//return an item by id
	@Override
	public UncountableItemsModel getItemById(String id) {
		return uncountableItemRepository.findById(id).get();
	}

	//get an item by name
	@Override
	public UncountableItemsModel getItemByName(String name) {
		return uncountableItemRepository.findByName(name).get(0);
	}

	//get a list of items of same status
	@Override
	public List<UncountableItemsModel> getItemsByType(String type) {
		return uncountableItemRepository.findByType(type);
	}

	//replace an existing item
	@Override
	public String updateItem(UncountableItemsModel updatedItem) {
		return uncountableItemRepository.save(updatedItem).getId();
	}

	//delete an item by id
	@Override
	public String deleteItem(String id) {
		
		uncountableItemRepository.deleteById(id);
		
		System.out.println("Deleted uncountable item with id: "+id);
		
		return id;
	}

	@Override
	public String updateAmount(double amount, String id) {
		
		//update the amount
		UncountableItemsModel uncountableItemsModel = 
				mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(id)),
						new Update().set("amount", amount),UncountableItemsModel.class);
		//return the id of the updated item.
		return uncountableItemsModel.getId();
	}

	//returns items based on site ids
	@Override
	public List<UncountableItemsModel> getItemsBySiteId(String siteId) {
		return uncountableItemRepository.findBySiteid(siteId);
	}

}
