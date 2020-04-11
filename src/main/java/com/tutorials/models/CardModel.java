package com.tutorials.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CardModel {

    private Integer id;
    @NotNull
    private String cardId;
    @NotNull
    private String cardNumber;
    @NotNull
    private String cardType;

    private UserModel user;

}
