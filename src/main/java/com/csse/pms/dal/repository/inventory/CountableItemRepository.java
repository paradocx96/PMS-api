package com.csse.pms.dal.repository.inventory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csse.pms.dal.model.inventory.CountableItemsModel;

@Repository
public interface CountableItemRepository extends MongoRepository<CountableItemsModel, String> {
	
	List<CountableItemsModel> findByName(String name);
	List<CountableItemsModel> findByType(String type);
	List<CountableItemsModel> findBySiteid(String siteId);

}
