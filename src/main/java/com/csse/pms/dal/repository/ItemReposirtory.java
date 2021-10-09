package com.csse.pms.dal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csse.pms.dal.model.ItemModel;

@Repository
public interface ItemReposirtory extends MongoRepository<ItemModel, String>{
	
	List<ItemModel> findBySupplierID(String id);

}
