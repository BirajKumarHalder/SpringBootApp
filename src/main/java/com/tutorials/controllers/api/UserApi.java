package com.tutorials.controllers.api;

import com.tutorials.models.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"User"}, description = "User management services", value = "user")
public interface UserApi {

    @PostMapping(value = "add-user")
    @ApiOperation(value = "User add", response = UserModel.class, nickname = "add-user")
    ResponseEntity<UserModel> addUser(@Validated @RequestBody(required = true) UserModel userRq);

    @GetMapping(value = "retrieve-user")
    @ApiOperation(value = "User retrieve", response = UserModel.class, responseContainer = "List", nickname = "retrieve-user")
    ResponseEntity<List<UserModel>> retrieveAllUsers();

    @GetMapping(value = "retrieve-user/{userId}")
    @ApiOperation(value = "User retrieve by id", response = UserModel.class, nickname = "retrieve-user-by-id")
    ResponseEntity<UserModel> retrieveUserById(@PathVariable(name = "userId") String userId);

    @PutMapping(value = "update-user/{userId}")
    @ApiOperation(value = "User update", response = UserModel.class, nickname = "update-user")
    ResponseEntity<UserModel> updateUser(@PathVariable(name = "userId") String userId, @Validated @RequestBody(required = true) UserModel userRq);

    @DeleteMapping(value = "delete-user/{userId}")
    @ApiOperation(value = "User delete", response = Boolean.class, nickname = "delete-user")
    ResponseEntity<Boolean> deleteUser(@PathVariable(name = "userId") String userId);

}
