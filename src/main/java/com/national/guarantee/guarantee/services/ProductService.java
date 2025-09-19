package com.national.guarantee.guarantee.services;

import com.national.guarantee.guarantee.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);
}
