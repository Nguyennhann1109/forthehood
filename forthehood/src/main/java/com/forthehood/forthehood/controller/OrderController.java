package com.forthehood.forthehood.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.forthehood.forthehood.entity.Order;
import com.forthehood.forthehood.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public Order checkout(@RequestParam Long userId){
        return orderService.checkout(userId);
    }

    @GetMapping("/my-orders")
    public List<Order> myOrders(@RequestParam Long userId){
        return orderService.getMyOrders(userId);
    }

    @GetMapping
    public List<Order> allOrders(){
        return orderService.getAllOrders();
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id,
                              @RequestParam String status){

        return orderService.updateStatus(id, status);
    }

}