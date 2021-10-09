package com.csse.pms.dal.adapter.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.csse.pms.dal.model.inventory.CountableItemsModel;
import com.csse.pms.dal.repository.inventory.CountableItemRepository;
import com.csse.pms.domain.inventory.CountableItemsDataAdpater;

@Component
public class CountableItemAdapterImpl implements CountableItemsDataAdpater {
	
	private CountableItemRepository countableItemRepository;
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public CountableItemAdapterImpl(CountableItemRepository countableItemRepository, 
			MongoTemplate mongoTemplate) {
		this.countableItemRepository = countableItemRepository;
		this.mongoTemplate = mongoTemplate;
	}

	//getting all the countable items
	@Override
	public List<CountableItemsModel> getAll() {
		
		return countableItemRepository.findAll();
	}

	//adding a new item
	@Override
	public String addItem(CountableItemsModel newItem) {
		return countableItemRepository.save(newItem).getId();
	}

	//get an item by id
	@Override
	public CountableItemsModel getItemById(String id) {
		return countableItemRepository.findById(id).get();
	}

	//get an item by name
	@Override
	public List<CountableItemsModel> getItemByName(String name) {
		return countableItemRepository.findByName(name);
	}

	@Override
	public List<CountableItemsModel> getItemsByType(String type) {
		return countableItemRepository.findByType(type);
	}
	
	//replaces an existing item
	@Override
	public String updateItem(CountableItemsModel updatedItem) {
		return countableItemRepository.save(updatedItem).getId();
	}

	//delete an item by id
	@Override
	public String deleteItem(String id) {
		countableItemRepository.deleteById(id);
		System.out.println("Deleted countable item with id : " + id);
		return id;
	}

	//update the quantity of an item
	@Override
	public String updateQuantity(int quantity, String id) {
		
		//update the quantity
		CountableItemsModel counableItemsModel = 
				mongoTemplate.findAndModify(Query.query(Criteria.where("id").is(id)),
						new Update().set("quantity", quantity),CountableItemsModel.class);
		
		//return the id
		return counableItemsModel.getId();
	}

	@Override
	public List<CountableItemsModel> getItemsBySiteId(String siteId) {
		
		return countableItemRepository.findBySiteid(siteId);
	}

}
