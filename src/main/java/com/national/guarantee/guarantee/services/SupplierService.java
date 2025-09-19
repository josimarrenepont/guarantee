package com.national.guarantee.guarantee.services;

import com.national.guarantee.guarantee.entities.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();

    Supplier findById(Long id);
}
