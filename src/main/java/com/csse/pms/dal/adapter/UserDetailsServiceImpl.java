package com.csse.pms.dal.adapter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csse.pms.dal.model.InternelUserModel;
import com.csse.pms.dal.model.SupplierModel;
import com.csse.pms.dal.repository.InternelUserRepository;
import com.csse.pms.dal.repository.SupplierRepository;

/**
 * 
 * @author Malwatta H.G.- IT19240848
 * 
 * This class is for find the by their unique data
 * like email(in here i get email instead of username)
 * 
 * Then, after find that user by their email set that details into user object
 * after that that object pass as a parameter to SupplierDetailsServiceImpl class
 * 
 * @see # SupplierDetailsServiceImpl.build(supplier);
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	InternelUserRepository internelUserRepository;

	//Find the user email in the database if not throw custom exception error
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<SupplierModel> supplierObj = supplierRepository.findByEmail(email);
		
		if(!supplierObj.isPresent()) {
			
			InternelUserModel internelUser = internelUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " not found!"));

			return UserDetailsImpl.buildInternelUsers(internelUser);
			
		}else {
			
			SupplierModel supplier = supplierRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email + " not found!"));
			
			return UserDetailsImpl.buildSupplier(supplier);

		}
		
	}

}
