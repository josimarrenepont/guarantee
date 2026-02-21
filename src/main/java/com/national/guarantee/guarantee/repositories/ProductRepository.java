package com.national.guarantee.guarantee.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.national.guarantee.guarantee.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Override
	@EntityGraph(attributePaths = {"suppliers"})
	Page<Product> findAll(Pageable pageable);
}
