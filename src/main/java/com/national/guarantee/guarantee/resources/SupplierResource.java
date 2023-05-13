package com.national.guarantee.guarantee.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.national.guarantee.guarantee.services.Supplier;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierResource {
	
	@GetMapping
	public ResponseEntity<Supplier> findAll() {
		
		Supplier supplier = new Supplier(null, "code123", "fornecedor1", "fornecedor1@gmail.com");
		
		return ResponseEntity.ok().body(supplier);
	}
	
}
