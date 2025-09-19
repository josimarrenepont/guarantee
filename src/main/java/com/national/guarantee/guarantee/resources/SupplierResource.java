package com.national.guarantee.guarantee.resources;

import java.util.List;

import com.national.guarantee.guarantee.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.national.guarantee.guarantee.entities.Supplier;
import com.national.guarantee.guarantee.services.impl.SupplierServiceImpl;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierResource {
	
	@Autowired
	private SupplierService service;
	
	@GetMapping
	public ResponseEntity<List<Supplier>> findAll() {
		List<Supplier> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Supplier> findById(@PathVariable Long id) {
		Supplier obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
