package com.tutorials.services;

import com.tutorials.models.UserModel;

import java.util.List;

public interface UserService {

    UserModel addUser(UserModel userRq);

    List<UserModel> retrieveAllUsers();

    UserModel retrieveUserById(String userId);

    UserModel updateUser(String userId, UserModel userRq);

    Boolean deleteUser(String userId);

}
