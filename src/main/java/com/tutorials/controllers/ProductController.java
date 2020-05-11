package com.tutorials.controllers;

import com.tutorials.models.ProductModel;
import com.tutorials.services.impls.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"Product"}, description = "Product management services", value = "product")
@RequestMapping("/secure")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping(value = "retrieve-product")
    @ApiOperation(value = "Product retrieve", response = ProductModel.class, responseContainer = "List", nickname = "retrieve-product")
    public ResponseEntity<List<ProductModel>> retrieveAllProducts() {
        return ResponseEntity.ok(productService.retrieveAllProducts());
    }

    @GetMapping(value = "retrieve-product/{productId}")
    @ApiOperation(value = "Product retrieve by id", response = ProductModel.class, nickname = "retrieve-product-by-id")
    ResponseEntity<ProductModel> retrieveProductById(@PathVariable(name = "productId") String productId) {
        return ResponseEntity.ok(productService.retrieveProductById(productId));
    }

    @DeleteMapping(value = "delete-product/{cartId}")
    @ApiOperation(value = "Product delete", response = Boolean.class, nickname = "delete-product")
    ResponseEntity<Boolean> deleteProduct(@PathVariable(name = "productId") String productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }


}
