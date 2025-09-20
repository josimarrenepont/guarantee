package com.national.guarantee.guarantee.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.national.guarantee.guarantee.entities.dto.ProductDTO;
import com.national.guarantee.guarantee.services.ProductService;
import com.national.guarantee.guarantee.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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
    public List<ProductDTO> findAll(){
		List<Product> products = repository.searchAll();
		return products.stream().map(ProductDTO::new).collect(Collectors.toList());
	}

	@Override
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Override
	public Product createProduct(ProductDTO obj) {
		Product product = new Product();
		product.setCodeProduct(obj.getCodeProduct());
		product.setPriceProduct(obj.getPriceProduct());
		product.setNameProduct(obj.getNameProduct());
		product.setRefProduct(obj.getRefProduct());

		return repository.save(product);
	}

	@Override
	public Product update(Long id, ProductDTO obj){
		try{
			Product entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, ProductDTO obj) {
		entity.setPriceProduct(obj.getPriceProduct());
	}
}
