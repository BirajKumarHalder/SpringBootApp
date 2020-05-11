package com.tutorials.controllers;

import com.tutorials.controllers.api.UserApi;
import com.tutorials.models.UserModel;
import com.tutorials.services.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public ResponseEntity<UserModel> addUser(String authorization, UserModel userRq) {
        return ResponseEntity.ok(userService.addUser(userRq));
    }

    @Override
    public ResponseEntity<List<UserModel>> retrieveAllUsers(String authorization) {
        return ResponseEntity.ok(userService.retrieveAllUsers());
    }

    @Override
    public ResponseEntity<UserModel> retrieveUserById(String authorization, String userId) {
        return ResponseEntity.ok(userService.retrieveUserById(userId));
    }

    @Override
    public ResponseEntity<UserModel> updateUser(String authorization, String userId, UserModel userRq) {
        return ResponseEntity.ok(userService.updateUser(userId, userRq));
    }

    @Override
    public ResponseEntity<Boolean> deleteUser(String authorization, String userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

}
