package com.forthehood.forthehood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forthehood.forthehood.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}