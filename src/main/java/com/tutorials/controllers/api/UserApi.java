package com.tutorials.controllers.api;

import com.tutorials.models.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"User"}, description = "User management services", value = "user")
@RequestMapping("/secure")
public interface UserApi {

    @PostMapping(value = "add-user")
    @ApiOperation(value = "User add", response = UserModel.class, nickname = "add-user")
    ResponseEntity<UserModel> addUser(@ApiParam(value = "Authorization", required = true) @RequestHeader(value = "Authorization") String authorization, @ApiParam(value = "user to create", required = true) @Validated @RequestBody(required = true) UserModel userRq);

    @GetMapping(value = "retrieve-user")
    @ApiOperation(value = "User retrieve", response = UserModel.class, responseContainer = "List", nickname = "retrieve-user")
    ResponseEntity<List<UserModel>> retrieveAllUsers(@ApiParam(value = "Authorization", required = true) @RequestHeader(value = "Authorization") String authorization);

    @GetMapping(value = "retrieve-user/{userId}")
    @ApiOperation(value = "User retrieve by id", response = UserModel.class, nickname = "retrieve-user-by-id")
    ResponseEntity<UserModel> retrieveUserById(@ApiParam(value = "Authorization", required = true) @RequestHeader(value = "Authorization") String authorizationm, @ApiParam(value = "user id", required = true) @PathVariable(name = "userId") String userId);

    @PutMapping(value = "update-user/{userId}")
    @ApiOperation(value = "User update", response = UserModel.class, nickname = "update-user")
    ResponseEntity<UserModel> updateUser(@ApiParam(value = "Authorization", required = true) @RequestHeader(value = "Authorization") String authorization, @ApiParam(value = "user id", required = true) @PathVariable(name = "userId") String userId, @ApiParam(value = "user to update", required = true) @Validated @RequestBody(required = true) UserModel userRq);

    @DeleteMapping(value = "delete-user/{userId}")
    @ApiOperation(value = "User delete", response = Boolean.class, nickname = "delete-user")
    ResponseEntity<Boolean> deleteUser(@ApiParam(value = "Authorization", required = true) @RequestHeader(value = "Authorization") String authorization, @ApiParam(value = "user id", required = true) @PathVariable(name = "userId") String userId);

}
