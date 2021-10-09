package com.csse.pms.domain;

import java.util.List;

import org.springframework.http.ResponseEntity;


public interface SupplierDataAdapter {
	
	ResponseEntity<?> registerSupplier(Supplier supplier);
	ResponseEntity<?> loginSupplier(Supplier supplier);
	List<Supplier> getAllSupplier();
	List<Supplier> getSupplierByStatus(String status);
	ResponseEntity<?> updateSupplierStatus(Supplier supplier);
	
	
}
