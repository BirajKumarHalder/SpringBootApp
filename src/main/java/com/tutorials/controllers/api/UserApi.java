package com.tutorials.controllers.api;

import com.tutorials.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserApi {

    @PostMapping(value = "add-user")
    ResponseEntity<UserModel> addUser(@Validated @RequestBody(required = true) UserModel userRq);

    @GetMapping(value = "retrieve-user")
    ResponseEntity<List<UserModel>> retrieveAllUsers();

    @GetMapping(value = "retrieve-user/{userId}")
    ResponseEntity<UserModel> retrieveUserById(@PathVariable(name = "userId") String userId);

    @PutMapping(value = "update-user/{userId}")
    ResponseEntity<UserModel> updateUser(@PathVariable(name = "userId") String userId, @Validated @RequestBody(required = true) UserModel userRq);

    @DeleteMapping(value = "delete-user/{userId}")
    ResponseEntity<Boolean> deleteUser(@PathVariable(name = "userId") String userId);

}
