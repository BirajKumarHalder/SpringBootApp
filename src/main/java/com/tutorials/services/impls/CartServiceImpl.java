package com.tutorials.services.impls;

import com.tutorials.models.CartModel;
import com.tutorials.models.ProductModel;
import com.tutorials.models.UserModel;
import com.tutorials.repositories.CartRepository;
import com.tutorials.repositories.entities.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl {

    @Autowired
    private CartRepository cartRepository;

    public List<CartModel> retrieveAllCarts() {
        List<CartEntity> cartEntities = cartRepository.findAll();
        List<CartModel> cartModels = Optional.ofNullable(cartEntities)
                .orElse(Collections.emptyList())
                .parallelStream()
                .map(cartEntity -> {
                    CartModel cartModel = new CartModel();
                    cartModel.setId(cartEntity.getId());
                    cartModel.setCartId(cartEntity.getCartId());
                    cartModel.setUser(Optional.ofNullable(cartEntity.getUser()).map(userEntity -> {
                        UserModel userModel = new UserModel();
                        userModel.setId(userEntity.getId());
                        userModel.setUserId(userEntity.getUserId());
                        userModel.setUserName(userEntity.getUserName());
                        userModel.setUserRole(userEntity.getUserRole());
                        userModel.setUserEmail(userEntity.getUserEmail());
                        userModel.setUserContact(userEntity.getUserContact());
                        return userModel;
                    }).orElse(new UserModel()));
                    cartModel.setProducts(Optional.ofNullable(cartEntity.getProducts())
                            .orElse(Collections.emptyList())
                            .stream()
                            .map(productEntity -> {
                                ProductModel productModel = new ProductModel();
                                productModel.setId(productEntity.getId());
                                productModel.setProductId(productEntity.getProductId());
                                productModel.setProductName(productEntity.getProductName());
                                productModel.setProductPrice(productEntity.getProductPrice());
                                return productModel;
                            }).collect(Collectors.toList()));
                    return cartModel;
                }).collect(Collectors.toList());
        return cartModels;
    }

    public CartModel retrieveCartById(String cartId) {
        CartEntity cartEntityObj = cartRepository.findByCartId(cartId);
        CartModel cartModelResp = Optional.ofNullable(cartEntityObj)
                .map(cartEntity -> {
                    CartModel cartModel = new CartModel();
                    cartModel.setId(cartEntity.getId());
                    cartModel.setCartId(cartEntity.getCartId());
                    cartModel.setUser(Optional.ofNullable(cartEntity.getUser()).map(userEntity -> {
                        UserModel userModel = new UserModel();
                        userModel.setId(userEntity.getId());
                        userModel.setUserId(userEntity.getUserId());
                        userModel.setUserName(userEntity.getUserName());
                        userModel.setUserRole(userEntity.getUserRole());
                        userModel.setUserEmail(userEntity.getUserEmail());
                        userModel.setUserContact(userEntity.getUserContact());
                        return userModel;
                    }).orElse(new UserModel()));
                    cartModel.setProducts(Optional.ofNullable(cartEntity.getProducts())
                            .orElse(Collections.emptyList())
                            .stream()
                            .map(productEntity -> {
                                ProductModel productModel = new ProductModel();
                                productModel.setId(productEntity.getId());
                                productModel.setProductId(productEntity.getProductId());
                                productModel.setProductName(productEntity.getProductName());
                                productModel.setProductPrice(productEntity.getProductPrice());
                                return productModel;
                            }).collect(Collectors.toList()));
                    return cartModel;
                }).orElse(new CartModel());
        return cartModelResp;
    }

    public Boolean deleteCart(String cartId) {
        CartEntity cartEntity = cartRepository.findByCartId(cartId);
        cartRepository.delete(cartEntity);
        return true;
    }
}
