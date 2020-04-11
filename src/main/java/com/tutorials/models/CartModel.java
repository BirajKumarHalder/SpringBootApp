package com.tutorials.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class CartModel {

    private Integer id;
    @NotNull
    private String cartId;

    private UserModel user;

    private List<ProductModel> products;


}
