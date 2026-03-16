package com.forthehood.forthehood.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forthehood.forthehood.entity.Cart;
import com.forthehood.forthehood.entity.CartItem;
import com.forthehood.forthehood.entity.Order;
import com.forthehood.forthehood.entity.OrderItem;
import com.forthehood.forthehood.entity.ProductVariant;
import com.forthehood.forthehood.repository.CartItemRepository;
import com.forthehood.forthehood.repository.CartRepository;
import com.forthehood.forthehood.repository.OrderItemRepository;
import com.forthehood.forthehood.repository.OrderRepository;
import com.forthehood.forthehood.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(CartRepository cartRepository,
                            CartItemRepository cartItemRepository,
                            OrderRepository orderRepository,
                            OrderItemRepository orderItemRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Order checkout(Long userId) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());

        if(cartItems.isEmpty()){
            throw new RuntimeException("Cart empty");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setStatus("PENDING");

        double total = 0;

        order = orderRepository.save(order);

        for(CartItem item : cartItems){

            ProductVariant variant = item.getProductVariant();

            double price = variant.getProduct().getPrice();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProductVariant(variant);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(price);

            total += price * item.getQuantity();

            orderItemRepository.save(orderItem);
        }

        order.setTotalPrice(total);

        orderRepository.save(order);

        cartItemRepository.deleteAll(cartItems);

        return order;
    }

    @Override
    public List<Order> getMyOrders(Long userId) {

        return orderRepository.findByUserId(userId);

    }

    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();

    }

    @Override
    public Order updateStatus(Long orderId, String status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        return orderRepository.save(order);
    }

    

}