package com.national.guarantee.guarantee.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.national.guarantee.guarantee.entities.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@GetMapping
	public ResponseEntity<Product> findAll() {
		Product product = new Product(null, "bobina", "110225", 50.50);

		return ResponseEntity.ok().body(product);

	}
}