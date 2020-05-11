package com.tutorials.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@ApiModel(description="All details about the cart")
public class CardModel {

    private Integer id;
    @NotNull(message = "Card Id cannot be null")
    private String cardId;
    @NotNull(message = "Card number cannot be null")
    private String cardNumber;
    @NotNull(message = "Card type cannot be null")
    private String cardType;

    private UserModel user;

}
