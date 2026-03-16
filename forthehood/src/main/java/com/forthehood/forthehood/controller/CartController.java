package com.forthehood.forthehood.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.forthehood.forthehood.entity.CartItem;
import com.forthehood.forthehood.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId,
                              @RequestParam Long productVariantId,
                              @RequestParam Long quantity){

        return cartService.addToCart(userId, productVariantId, quantity);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId){
        return cartService.getCart(userId);
    }

    @PutMapping("/update")
    public CartItem updateQuantity(@RequestParam Long cartItemId,
                                   @RequestParam Long quantity){

        return cartService.updateQuantity(cartItemId, quantity);
    }

    @DeleteMapping("/remove/{id}")
    public void removeItem(@PathVariable Long id){
        cartService.removeItem(id);
    }

}