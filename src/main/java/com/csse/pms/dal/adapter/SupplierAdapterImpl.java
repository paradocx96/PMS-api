package com.csse.pms.dal.adapter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.csse.pms.dal.model.ERole;
import com.csse.pms.dal.model.EmailSender;
import com.csse.pms.dal.model.Role;
import com.csse.pms.dal.model.SupplierModel;
import com.csse.pms.dal.repository.InternelUserRepository;
import com.csse.pms.dal.repository.RoleMongoRepository;
import com.csse.pms.dal.repository.SupplierRepository;
import com.csse.pms.domain.Supplier;
import com.csse.pms.domain.SupplierDataAdapter;
import com.csse.pms.dto.JwtResponseDto;
import com.csse.pms.dto.SupplierMessageResponseDto;
import com.csse.pms.security.jwt.JwtUtils;
import com.csse.pms.util.CommonConstants;



/**
 * 
 * @author Malwatta H.G.- IT19240848
 * 
 * This class handle by the supplier related methods
 *     - @see #registerSupplier(Supplier) - register 
 *     - @see #loginSupplier(Supplier) - login
 *     - @see #getAllSupplier() - get all suppliers
 *     - @see #getSupplierByStatus(String) - get supplier by status
 *     - @see #updateSupplierStatus(Supplier) - update supplier status
 *    
 *
 */

@Component
public class SupplierAdapterImpl implements SupplierDataAdapter{

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	RoleMongoRepository roleMongoRepository;
	
	@Autowired
	private InternelUserRepository internelUserRepository;
	
	private final MongoTemplate mongoTemplate = null;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	/**
     * Initialize Logger
     */
    public static final Logger LOGGER = Logger.getLogger(SupplierAdapterImpl.class.getName());

	@Override
	public ResponseEntity<?> registerSupplier(Supplier supplier) {
		
		/**
		 * Check whether user mail is already in the database,
		 * because user mail should be unique 
		 *  
		 */
		if(supplierRepository.existsByEmail(supplier.getEmail())) {
			return ResponseEntity.badRequest().body(new SupplierMessageResponseDto(CommonConstants.SUPPLIER_EMAIL_REGISTRATION_ERROR_MSG));
		}
		
		if(internelUserRepository.existsByEmail(supplier.getEmail())) {
			return ResponseEntity.badRequest().body(new SupplierMessageResponseDto(CommonConstants.SUPPLIER_EMAIL_REGISTRATION_ERROR_MSG));
		}
		
		SupplierModel supplierDetails = new SupplierModel(
				supplier.getName(),
				supplier.getEmail(),
				passwordEncoder.encode(supplier.getPassword()),
				supplier.getContactNo(),
				supplier.getAddress(),
				supplier.getLocation(),
				supplier.getStatus()
				);
		
		//Create new HashSet to store user Roles
		Set<Role> roles = new HashSet<>();
						
		//If it is true, Add ROLE_USER to that user
		Role userRole = roleMongoRepository.findByName(ERole.ROLE_SUPPLIER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				
		roles.add(userRole);
		
		//set all roles to user object
		supplierDetails.setRoles(roles);
		
		supplierRepository.save(supplierDetails);
		
		/**
		 * Set the values to email sender class and call 
		 * send email method to send the email
		 * 
		 */
		emailSender.setEmail(supplier.getEmail());
		emailSender.setUsername(supplier.getName());
		
		try {
				emailSender.sendEmail();
				
		} catch (UnsupportedEncodingException | MessagingException e) {
			
			 LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		//return success MSG to frontEnd user is registered successfully
		return ResponseEntity.ok(new SupplierMessageResponseDto(CommonConstants.SUPPLIER_REGISTRATION_SUCCESS_MSG));
	}

	@Override
	public ResponseEntity<?> loginSupplier(Supplier supplier) {
		
		
				//Get user name and password and create new AuthenticationToken 
				Authentication authentication = authenticationManager.authenticate(
								new UsernamePasswordAuthenticationToken(supplier.getEmail(), supplier.getPassword()));

				//Set above assigned user credentials using Authentication object
				SecurityContextHolder.getContext().setAuthentication(authentication);
						
				//After that create new JWT Token for that person
				String jwt = jwtUtils.generateJwtToken(authentication);
						
				//Then get authentication principles and set that UserDetailimpl object 
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
						
				//Get getAuthorities and set to List object
				List<String> roles = userDetails.getAuthorities().stream()
								.map(item -> item.getAuthority())
								.collect(Collectors.toList());
				
				//This is for check the program display correct values or not
				System.out.println(userDetails.getUsername());
				System.out.println(userDetails.getPassword());
				System.out.println(jwt);
				System.out.println(roles.toString());
				
				
				//Return JWT response to FrontEnd
				return ResponseEntity.ok(new JwtResponseDto(jwt, 
															userDetails.getId(), 
															userDetails.getUsername(), 
															userDetails.getName(), 
															roles));
	}

	@Override
	public List<Supplier> getAllSupplier() {
		
		List<SupplierModel> suppList;
		List<Supplier> suppListReturn = new ArrayList<>();
		
		try {
			suppList = supplierRepository.findAll();
			
			for(SupplierModel supplierModel: suppList) {
				
				Supplier supplierObj = new Supplier();
				
				supplierObj.setId(supplierModel.getId());
				supplierObj.setName(supplierModel.getName());
				supplierObj.setEmail(supplierModel.getEmail());
				supplierObj.setAddress(supplierModel.getAddress());
				supplierObj.setContactNo(supplierModel.getContactNo());
				supplierObj.setLocation(supplierModel.getLocation());
				supplierObj.setStatus(supplierModel.getStatus());
				
				suppListReturn.add(supplierObj);
				
			}
			
		} catch (Exception e) {
			 LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return suppListReturn;
	}

	@Override
	public List<Supplier> getSupplierByStatus(String status) {
		
		List<SupplierModel> suppList;
		List<Supplier> suppListReturn = new ArrayList<>();
		
		try {
			
			suppList = supplierRepository.findByStatus(status);
			

			for(SupplierModel supplierModel: suppList) {
				
				Supplier supplierObj = new Supplier();
				
				supplierObj.setId(supplierModel.getId());
				supplierObj.setName(supplierModel.getName());
				supplierObj.setEmail(supplierModel.getEmail());
				supplierObj.setAddress(supplierModel.getAddress());
				supplierObj.setContactNo(supplierModel.getContactNo());
				supplierObj.setLocation(supplierModel.getLocation());
				supplierObj.setStatus(supplierModel.getStatus());
				
				suppListReturn.add(supplierObj);
				
			}
			
			
		} catch (Exception e) {
			 LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return suppListReturn;
	}

	@Override
	public ResponseEntity<?> updateSupplierStatus(Supplier supplier) {
		
		try {
			
			SupplierModel supplierObj = supplierRepository.findById(supplier.getId()).get();
			
			
//			SupplierModel supplierObj = mongoTemplate.findAndModify(
//					Query.query(Criteria.where(CommonConstants.ID).is(supplier.getId())),
//					new Update()
//					.set(CommonConstants.SUPPLIER_STATUS, supplier.getStatus()), 
//					SupplierModel.class);
			
			if(supplierObj != null) {
				
				supplierObj.setStatus(supplier.getStatus());
				supplierRepository.save(supplierObj);
				
				return ResponseEntity.ok(new SupplierMessageResponseDto(CommonConstants.SUPPLIER_STAUS_UPDATE_SUCCESSFULLY));
			}else {
				return ResponseEntity.badRequest().body(new SupplierMessageResponseDto(CommonConstants.SUPPLIER_DOESNT_EXIST));
			}
			
		} catch (Exception e) {
			 LOGGER.log(Level.SEVERE, e.getMessage());
			 return ResponseEntity.badRequest().body(new SupplierMessageResponseDto(CommonConstants.SUPPLIER_STAUS_UPDATE_ERROR));
		}
	
	}
	
}
