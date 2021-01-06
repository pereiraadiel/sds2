package com.adielpereira.dsdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adielpereira.dsdelivery.dto.OrderDTO;
import com.adielpereira.dsdelivery.dto.ProductDTO;
import com.adielpereira.dsdelivery.entities.Order;
import com.adielpereira.dsdelivery.entities.OrderStatus;
import com.adielpereira.dsdelivery.entities.Product;
import com.adielpereira.dsdelivery.repositories.OrderRepository;
import com.adielpereira.dsdelivery.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly= true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(elem -> new OrderDTO(elem)).collect(Collectors.toList());
	}
	
	@Transactional()
	public OrderDTO insert(OrderDTO dto) { 
		Order order = new Order(null,dto.getAddress(), dto.getLatitude(), 
				dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
		for ( ProductDTO productDTO: dto.getProducts() ) {
			Product product = productRepository.getOne(productDTO.getId());
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		return new OrderDTO(order);
	}
}
