package com.national.guarantee.guarantee.services.impl;

import java.util.List;
import java.util.Optional;

import com.national.guarantee.guarantee.services.SupplierService;
import com.national.guarantee.guarantee.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.national.guarantee.guarantee.entities.Supplier;
import com.national.guarantee.guarantee.repositories.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	

	private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
	public List<Supplier> findAll(){
		return repository.findAll();
	}

	@Override
	public Supplier findById(Long id) {
		Optional<Supplier> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}