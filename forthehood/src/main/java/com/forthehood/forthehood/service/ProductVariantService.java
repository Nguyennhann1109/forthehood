package com.forthehood.forthehood.service;

import java.util.List;

import com.forthehood.forthehood.entity.ProductVariant;

public interface ProductVariantService {

    List<ProductVariant> getAllVariants();

    ProductVariant getVariantById(Long id);

    ProductVariant createVariant(ProductVariant variant);

    ProductVariant updateVariant(Long id, ProductVariant variant);

    void deleteVariant(Long id);

}