package com.forthehood.forthehood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forthehood.forthehood.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

    List<CartItem> findByCartId(Long cartId);

}