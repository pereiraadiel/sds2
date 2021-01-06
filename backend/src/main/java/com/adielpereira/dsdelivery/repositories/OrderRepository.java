package com.adielpereira.dsdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adielpereira.dsdelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
