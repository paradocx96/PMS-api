package com.csse.pms.dal.repository.inventory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csse.pms.dal.model.inventory.UncountableItemsModel;

@Repository
public interface UncountableItemRepository extends MongoRepository<UncountableItemsModel, String> {
	
	List<UncountableItemsModel> findByName(String name);
	List<UncountableItemsModel> findByType(String type);
	List<UncountableItemsModel> findBySiteid(String siteId);

}
