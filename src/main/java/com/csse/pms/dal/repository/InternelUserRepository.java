package com.csse.pms.dal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csse.pms.dal.model.InternelUserModel;


@Repository
public interface InternelUserRepository extends MongoRepository<InternelUserModel, String> {

	//Create method for find the user by email
	Optional<InternelUserModel> findByEmail(String email);
	
	//Create this method to find out mail already in the Database or not
	Boolean existsByEmail(String email);
}
