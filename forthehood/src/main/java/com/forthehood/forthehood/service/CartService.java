package com.forthehood.forthehood.service;

import java.util.List;

import com.forthehood.forthehood.entity.CartItem;

public interface CartService {

    CartItem addToCart(Long userId, Long productVariantId, Long quantity);

    List<CartItem> getCart(Long userId);

    CartItem updateQuantity(Long cartItemId, Long quantity);

    void removeItem(Long cartItemId);

}