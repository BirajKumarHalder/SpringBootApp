package com.tutorials.models;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@ApiModel(description = "All details about the user")
public class UserModel {

    private Integer id;
    @NotNull(message = "User Id cannot be null")
    private String userId;
    @NotNull(message = "Name cannot be null")
    private String userName;
    @NotNull(message = "Role cannot be null")
    private String userRole;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email is not is proper format")
    private String userEmail;
    @NotNull(message = "Contact cannot be null")
    private String userContact;

    private CartModel cart;

    private List<CardModel> cards;

}
