package com.javams.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javams.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
