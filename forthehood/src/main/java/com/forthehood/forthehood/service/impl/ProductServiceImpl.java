package com.forthehood.forthehood.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.forthehood.forthehood.entity.Product;
import com.forthehood.forthehood.entity.ProductVariant;
import com.forthehood.forthehood.repository.ProductRepository;
import com.forthehood.forthehood.repository.ProductVariantRepository;
import com.forthehood.forthehood.service.ProductService;
import com.forthehood.forthehood.dto.ProductDetailDTO;
import com.forthehood.forthehood.dto.VariantDTO;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductVariantRepository productVariantRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductVariantRepository productVariantRepository) {
        this.productRepository = productRepository;
        this.productVariantRepository = productVariantRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // PRODUCT DETAIL API
    @Override
    public ProductDetailDTO getProductDetail(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        List<ProductVariant> variants =
                productVariantRepository.findByProductId(id);

        ProductDetailDTO dto = new ProductDetailDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());

        // SIZE LIST
        List<String> sizes = variants.stream()
                .map(v -> v.getSize().getName())
                .distinct()
                .collect(Collectors.toList());

        // COLOR LIST
        List<String> colors = variants.stream()
                .map(v -> v.getColor().getName())
                .distinct()
                .collect(Collectors.toList());

        dto.setSizes(sizes);
        dto.setColors(colors);

        // VARIANT LIST
        List<VariantDTO> variantDTOList = variants.stream().map(v -> {

            VariantDTO vd = new VariantDTO();

            vd.setId(v.getId());
            vd.setSize(v.getSize().getName());
            vd.setColor(v.getColor().getName());
            vd.setStock(v.getStock());

            return vd;

        }).collect(Collectors.toList());

        dto.setVariants(variantDTOList);

        return dto;
    }

    @Override
    public List<Product> getByCategorySlug(String slug) {
        return productRepository.findByCategory_Slug(slug);
    }

}