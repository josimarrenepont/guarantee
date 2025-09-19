package com.national.guarantee.guarantee.services.impl;

import java.util.List;
import java.util.Optional;

import com.national.guarantee.guarantee.services.ProductService;
import com.national.guarantee.guarantee.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.national.guarantee.guarantee.entities.Product;
import com.national.guarantee.guarantee.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {


	private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }
	@Override
    public List<Product> findAll(){
		return repository.searchAll();
	}

	@Override
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
