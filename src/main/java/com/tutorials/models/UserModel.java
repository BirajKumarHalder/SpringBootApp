package com.tutorials.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class UserModel {

    private Integer id;
    @NotNull
    private String userId;
    @NotNull
    private String userName;
    @NotNull
    private String userRole;
    @NotNull
    @Email
    private String userEmail;
    @NotNull
    private String userContact;

    private CartModel cart;

    private List<CardModel> cards;

}
