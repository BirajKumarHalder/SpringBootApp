package com.tutorials.controllers;

import com.tutorials.models.CartModel;
import com.tutorials.models.UserModel;
import com.tutorials.services.impls.CartServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"Cart"}, description = "Cart management services", value = "cart")
@RequestMapping("/secure")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @GetMapping(value = "retrieve-cart")
    @ApiOperation(value = "User retrieve", response = UserModel.class, responseContainer = "List", nickname = "retrieve-user")
    public ResponseEntity<List<CartModel>> retrieveAllCarts() {
        return ResponseEntity.ok(cartService.retrieveAllCarts());
    }

    @GetMapping(value = "retrieve-cart/{cartId}")
    @ApiOperation(value = "Cart retrieve by id", response = CartModel.class, nickname = "retrieve-cart-by-id")
    ResponseEntity<CartModel> retrieveCartById(@PathVariable(name = "cartId") String cartId) {
        return ResponseEntity.ok(cartService.retrieveCartById(cartId));
    }

    @DeleteMapping(value = "delete-cart/{cartId}")
    @ApiOperation(value = "Cart delete", response = Boolean.class, nickname = "delete-cart")
    ResponseEntity<Boolean> deleteCart(@PathVariable(name = "cartId") String cartId) {
        return ResponseEntity.ok(cartService.deleteCart(cartId));
    }

}
