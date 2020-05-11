package com.tutorials.controllers.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = {"Auth"}, description = "Authentication management services", value = "auth")
public interface AuthApi {

    @GetMapping(value = "get-access-token")
    @ApiOperation(value = "Get access token", response = String.class, nickname = "get-access-token")
    ResponseEntity<String> getAccessToken(@ApiParam(value = "user id", required = true) @RequestParam(name = "userId", required = true) String userId);

}
