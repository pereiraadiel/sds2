package com.adielpereira.dsdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adielpereira.dsdelivery.dto.OrderDTO;
import com.adielpereira.dsdelivery.entities.Order;
import com.adielpereira.dsdelivery.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly= true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(elem -> new OrderDTO(elem)).collect(Collectors.toList());
	}
}
