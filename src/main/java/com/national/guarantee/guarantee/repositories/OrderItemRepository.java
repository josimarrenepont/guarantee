package com.national.guarantee.guarantee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.national.guarantee.guarantee.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
