package com.forthehood.forthehood.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forthehood.forthehood.dto.ProductDetailDTO;
import com.forthehood.forthehood.entity.Product;
import com.forthehood.forthehood.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // GET ALL PRODUCTS
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // CREATE PRODUCT
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    // PRODUCT DETAIL API
    @GetMapping("/{id}/detail")
    public ProductDetailDTO getProductDetail(@PathVariable Long id){
        return productService.getProductDetail(id);
    }

    // 🔥 GET PRODUCTS BY CATEGORY
    @GetMapping("/category/{slug}")
    public List<Product> getByCategory(@PathVariable String slug){
        return productService.getByCategorySlug(slug);
}

}