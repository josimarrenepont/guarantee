package com.national.guarantee.guarantee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.national.guarantee.guarantee.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
