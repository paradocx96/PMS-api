package com.csse.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.csse.pms.api.InternelUserApi;
import com.csse.pms.domain.InternelUser;

import com.csse.pms.util.CommonConstants;

@RestController
@RequestMapping(CommonConstants.INTERNEL_USER_REQUEST_MAPPING)
@CrossOrigin(origins = CommonConstants.STAR, allowedHeaders = CommonConstants.STAR, exposedHeaders = CommonConstants.STAR)

public class InternelUserController {
	
	@Autowired
	private InternelUserApi internelUserApi;
	
	
	@PostMapping(CommonConstants.INTERNEL_USER_POST_MAPPING_REGISTER)
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> registerInternelUser(@RequestBody InternelUser internelUser){
		return internelUserApi.registerInternelUser(internelUser);
	}
	
	@PostMapping(CommonConstants.INTERNEL_USER_POST_MAPPING_LOGIN)
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> loginInternelUser(@RequestBody InternelUser internelUser){
		return internelUserApi.loginInternelUser(internelUser);
	}
	

	@GetMapping(CommonConstants.INTERNAL_USER_GET_ALL)
    @ResponseStatus(HttpStatus.OK)
	public List<InternelUser> getAllSuppliers(){
		return internelUserApi.getAllInternalUsers();
	}

}
