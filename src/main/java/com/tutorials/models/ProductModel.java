package com.tutorials.models;

import com.tutorials.repositories.entities.CartEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductModel {

    private Integer id;
    @NotNull
    private String productId;
    @NotNull
    private String productName;
    @NotNull
    private Long productPrice;

    private List<CartEntity> carts;

}
