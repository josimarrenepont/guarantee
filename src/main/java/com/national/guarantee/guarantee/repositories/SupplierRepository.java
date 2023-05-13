package com.national.guarantee.guarantee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.national.guarantee.guarantee.services.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	
}
