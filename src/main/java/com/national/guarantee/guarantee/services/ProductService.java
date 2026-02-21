package com.national.guarantee.guarantee.services;

import com.national.guarantee.guarantee.entities.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    Page<ProductDTO> findAllPaged(Pageable pageable);

    ProductDTO findById(Long id);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO update(Long id, ProductDTO obj);
}
