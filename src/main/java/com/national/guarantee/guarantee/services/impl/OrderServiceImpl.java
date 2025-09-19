package com.national.guarantee.guarantee.services.impl;

import java.util.List;
import java.util.Optional;

import com.national.guarantee.guarantee.services.OrderService;
import com.national.guarantee.guarantee.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.national.guarantee.guarantee.entities.Order;
import com.national.guarantee.guarantee.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {


	private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }
	@Override
    public List<Order> findAll(){
		return repository.findAll();
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}