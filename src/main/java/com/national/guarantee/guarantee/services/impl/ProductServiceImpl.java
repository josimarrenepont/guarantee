package com.national.guarantee.guarantee.services.impl;

import com.national.guarantee.guarantee.entities.Product;
import com.national.guarantee.guarantee.entities.dto.ProductDTO;
import com.national.guarantee.guarantee.repositories.ProductRepository;
import com.national.guarantee.guarantee.services.ProductService;
import com.national.guarantee.guarantee.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<ProductDTO> findAll() {
		List<Product> products = repository.findAll();
		return products.stream().map(ProductDTO::new).collect(Collectors.toList());
	}

	@Override
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ProductDTO(entity);
	}

	@Override
	public ProductDTO createProduct(ProductDTO obj) {
		Product product = new Product();
		product.setCodeProduct(obj.getCodeProduct());
		product.setPriceProduct(obj.getPriceProduct());
		product.setNameProduct(obj.getNameProduct());
		product.setRefProduct(obj.getRefProduct());

		Product savedProduct = repository.save(product);
		return new ProductDTO(savedProduct);
	}

	@Override
	public ProductDTO update(Long id, ProductDTO obj) {
		try {
			Product entity = repository.getReferenceById(id);
			updateData(entity, obj);
			Product updatedProduct = repository.save(entity);
			return new ProductDTO(updatedProduct);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, ProductDTO obj) {
		entity.setNameProduct(obj.getNameProduct());
	}
}
