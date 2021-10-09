package com.csse.pms.dal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csse.pms.dal.model.SupplierModel;


@Repository
public interface SupplierRepository extends MongoRepository<SupplierModel, String> {

	//Create method for find the user by email
	Optional<SupplierModel> findByEmail(String email);
	
	//Create this method to find out mail already in the Database or not
	Boolean existsByEmail(String email);
	
	//Create this method to find out all status the Database
	List<SupplierModel> findByStatus(String status);
}
