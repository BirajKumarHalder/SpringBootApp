package com.tutorials.models;

import com.tutorials.repositories.entities.CartEntity;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@ApiModel(description = "All details about the product")
public class ProductModel {

    private Integer id;
    @NotNull(message = "Product Id cannot be null")
    private String productId;
    @NotNull(message = "Product name cannot be null")
    private String productName;
    @NotNull(message = "Product price cannot be null")
    private Long productPrice;

    private List<CartEntity> carts;

}
