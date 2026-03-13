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

import com.forthehood.forthehood.entity.ProductVariant;
import com.forthehood.forthehood.service.ProductVariantService;

@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {

    private final ProductVariantService variantService;

    public ProductVariantController(ProductVariantService variantService){
        this.variantService = variantService;
    }

    @GetMapping
    public List<ProductVariant> getAllVariants(){
        return variantService.getAllVariants();
    }

    @GetMapping("/{id}")
    public ProductVariant getVariantById(@PathVariable Long id){
        return variantService.getVariantById(id);
    }

    @PostMapping
    public ProductVariant createVariant(@RequestBody ProductVariant variant){
        return variantService.createVariant(variant);
    }

    @PutMapping("/{id}")
    public ProductVariant updateVariant(@PathVariable Long id,
                                        @RequestBody ProductVariant variant){
        return variantService.updateVariant(id, variant);
    }

    @DeleteMapping("/{id}")
    public void deleteVariant(@PathVariable Long id){
        variantService.deleteVariant(id);
    }

}