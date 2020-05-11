package com.tutorials.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@ApiModel(description = "All details about the cart")
public class CartModel {

    private Integer id;
    @NotNull(message = "Cart Id cannot be null")
    private String cartId;

    private UserModel user;

    private List<ProductModel> products;


}
