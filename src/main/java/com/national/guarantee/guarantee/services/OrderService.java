package com.national.guarantee.guarantee.services;

import com.national.guarantee.guarantee.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order findById(Long id);
}
