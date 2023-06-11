package com.national.guarantee.guarantee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.national.guarantee.guarantee.entities.OrderItem;
import com.national.guarantee.guarantee.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
