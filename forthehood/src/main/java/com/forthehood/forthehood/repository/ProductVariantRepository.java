package com.forthehood.forthehood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forthehood.forthehood.entity.ProductVariant;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {

    List<ProductVariant> findByProductId(Long productId);

}