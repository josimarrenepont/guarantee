package com.national.guarantee.guarantee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.national.guarantee.guarantee.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value= "SELECT obj FROM Product obj JOIN FETCH obj.suppliers")
	List<Product> searchAll();
}
