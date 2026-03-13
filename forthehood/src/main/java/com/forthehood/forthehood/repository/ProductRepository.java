package com.forthehood.forthehood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forthehood.forthehood.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}