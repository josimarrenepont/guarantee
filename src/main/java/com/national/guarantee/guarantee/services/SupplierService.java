package com.national.guarantee.guarantee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.national.guarantee.guarantee.entities.Supplier;
import com.national.guarantee.guarantee.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository repository;
	
	public List<Supplier> findAll(){
		return repository.findAll();
	}
	public Supplier findById(Long id) {
		Optional<Supplier> obj = repository.findById(id);
		return obj.get();
	}
	
}