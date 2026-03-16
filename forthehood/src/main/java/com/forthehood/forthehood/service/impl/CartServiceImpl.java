package com.forthehood.forthehood.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forthehood.forthehood.entity.Cart;
import com.forthehood.forthehood.entity.CartItem;
import com.forthehood.forthehood.entity.ProductVariant;
import com.forthehood.forthehood.repository.CartItemRepository;
import com.forthehood.forthehood.repository.CartRepository;
import com.forthehood.forthehood.repository.ProductVariantRepository;
import com.forthehood.forthehood.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductVariantRepository productVariantRepository;

    public CartServiceImpl(CartRepository cartRepository,
                           CartItemRepository cartItemRepository,
                           ProductVariantRepository productVariantRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productVariantRepository = productVariantRepository;
    }

    @Override
    public CartItem addToCart(Long userId, Long productVariantId, Long quantity) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUserId(userId);
                    return cartRepository.save(newCart);
                });

        ProductVariant variant = productVariantRepository.findById(productVariantId)
                .orElseThrow(() -> new RuntimeException("Variant not found"));

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProductVariant(variant);
        item.setQuantity(quantity);

        return cartItemRepository.save(item);
    }

    @Override
    public List<CartItem> getCart(Long userId) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        return cartItemRepository.findByCartId(cart.getId());
    }

    @Override
    public CartItem updateQuantity(Long cartItemId, Long quantity) {

        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item.setQuantity(quantity);

        return cartItemRepository.save(item);
    }

    @Override
    public void removeItem(Long cartItemId) {

        cartItemRepository.deleteById(cartItemId);

    }

}