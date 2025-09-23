package com.national.guarantee.guarantee.services;

import com.national.guarantee.guarantee.entities.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO update(Long id, ProductDTO obj);
}
