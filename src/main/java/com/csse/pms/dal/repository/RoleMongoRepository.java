
package com.csse.pms.dal.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.csse.pms.dal.model.ERole;
import com.csse.pms.dal.model.Role;


//created new RoleRepository to find out user role in the database
@Repository
public interface RoleMongoRepository extends MongoRepository<Role, String> {
	
	Optional<Role> findByName(ERole name);
	
}
