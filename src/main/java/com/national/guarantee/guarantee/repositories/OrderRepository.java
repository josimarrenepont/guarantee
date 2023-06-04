package com.national.guarantee.guarantee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.national.guarantee.guarantee.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
