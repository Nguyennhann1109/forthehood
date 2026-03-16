package com.forthehood.forthehood.service;

import java.util.List;

import com.forthehood.forthehood.entity.Order;

public interface OrderService {

    Order checkout(Long userId);

    List<Order> getMyOrders(Long userId);

    List<Order> getAllOrders();

    Order updateStatus(Long orderId, String status);

}