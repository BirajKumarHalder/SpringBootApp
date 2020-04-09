package com.tutorials.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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

}
