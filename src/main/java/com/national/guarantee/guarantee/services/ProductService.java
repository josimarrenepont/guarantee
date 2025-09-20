package com.national.guarantee.guarantee.services;

import com.national.guarantee.guarantee.entities.Product;
import com.national.guarantee.guarantee.entities.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    Product findById(Long id);

    Product createProduct(ProductDTO productDTO);

    Product update(Long id, ProductDTO obj);
}
