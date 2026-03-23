package com.forthehood.forthehood.service;

import java.util.List;

import com.forthehood.forthehood.dto.ProductDetailDTO;
import com.forthehood.forthehood.entity.Product;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    // PRODUCT DETAIL
    ProductDetailDTO getProductDetail(Long id);

    // 🔥 NEW: FILTER BY CATEGORY
    List<Product> getByCategorySlug(String slug);
}