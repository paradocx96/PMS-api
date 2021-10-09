package com.csse.pms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csse.pms.domain.InternelUser;
import com.csse.pms.domain.InternelUserDataAdapter;



@Service
public class InternelUserApi {

	@Autowired
	private InternelUserDataAdapter internelUserDataAdapter;
	
	 /**
     * This Method gets parameter as Supplier object.
     * Then call supplier register method in Adapter.
     *
     * @param internal user - Relevant Internal user object from Controller.
     * @return ResponseEntity<?> - Customized message will be return.
     * @see #registerInternelUser(InternelUser)
     */
	
	public ResponseEntity<?> registerInternelUser(InternelUser internelUser){
		return internelUserDataAdapter.registerInternelUser(internelUser);
	}

	public ResponseEntity<?> loginInternelUser(InternelUser internelUser){
		return internelUserDataAdapter.loginInternelUser(internelUser);
	}
	
	public List<InternelUser> getAllInternalUsers(){
		return internelUserDataAdapter.getAllInternalUsers();
	}
}
