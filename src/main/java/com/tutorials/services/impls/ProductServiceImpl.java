package com.tutorials.services.impls;

import com.tutorials.models.ProductModel;
import com.tutorials.repositories.ProductRepository;
import com.tutorials.repositories.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> retrieveAllProducts() {
        return Optional.ofNullable(productRepository.findAll())
                .orElse(Collections.emptyList())
                .parallelStream()
                .map(productEntity -> {
                    ProductModel productModel = new ProductModel();
                    productModel.setId(productEntity.getId());
                    productModel.setProductId(productEntity.getProductId());
                    productModel.setProductName(productEntity.getProductName());
                    productModel.setProductPrice(productEntity.getProductPrice());
                    return productModel;
                }).collect(Collectors.toList());
    }

    public ProductModel retrieveProductById(String productId) {
        return Optional.ofNullable(productRepository.findByProductId(productId))
                .map(productEntity -> {
                    ProductModel productModel = new ProductModel();
                    productModel.setId(productEntity.getId());
                    productModel.setProductId(productEntity.getProductId());
                    productModel.setProductName(productEntity.getProductName());
                    productModel.setProductPrice(productEntity.getProductPrice());
                    return productModel;
                }).orElse(new ProductModel());
    }

    public Boolean deleteProduct(String productId) {
        ProductEntity productEntity = productRepository.findByProductId(productId);
        productRepository.delete(productEntity);
        return true;
    }
}
