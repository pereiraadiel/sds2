package com.adielpereira.dsdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adielpereira.dsdelivery.dto.ProductDTO;
import com.adielpereira.dsdelivery.entities.Product;
import com.adielpereira.dsdelivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly= true)
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(elem -> new ProductDTO(elem)).collect(Collectors.toList());
	}
}
