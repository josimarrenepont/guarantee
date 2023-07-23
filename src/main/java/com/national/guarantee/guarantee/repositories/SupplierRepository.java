package com.national.guarantee.guarantee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.national.guarantee.guarantee.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	@Query(value= "SELECT obj FROM Supplier obj JOIN FETCH obj.branchs")
	List<Supplier> searchAll();
	
	
}
