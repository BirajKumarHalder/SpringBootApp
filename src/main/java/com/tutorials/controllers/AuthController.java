package com.tutorials.controllers;

import com.tutorials.controllers.api.AuthApi;
import com.tutorials.services.impls.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    @Autowired
    private AuthServiceImpl authService;

    @Override
    public ResponseEntity<String> getAccessToken(String userId) {
        return ResponseEntity.ok(authService.getAccessToken(userId));
    }
}
