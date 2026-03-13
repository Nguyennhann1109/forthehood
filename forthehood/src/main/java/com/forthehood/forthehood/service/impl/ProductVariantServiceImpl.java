package com.forthehood.forthehood.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forthehood.forthehood.entity.ProductVariant;
import com.forthehood.forthehood.repository.ProductVariantRepository;
import com.forthehood.forthehood.service.ProductVariantService;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository variantRepository;

    public ProductVariantServiceImpl(ProductVariantRepository variantRepository){
        this.variantRepository = variantRepository;
    }

    @Override
    public List<ProductVariant> getAllVariants(){
        return variantRepository.findAll();
    }

    @Override
    public ProductVariant getVariantById(Long id){
        return variantRepository.findById(id).orElse(null);
    }

    @Override
    public ProductVariant createVariant(ProductVariant variant){
        return variantRepository.save(variant);
    }

    @Override
    public ProductVariant updateVariant(Long id, ProductVariant variant){
        variant.setId(id);
        return variantRepository.save(variant);
    }

    @Override
    public void deleteVariant(Long id){
        variantRepository.deleteById(id);
    }

}