package com.danilo.coinmanager.controller;

import com.danilo.coinmanager.dto.auth.RegisterRequest;
import com.danilo.coinmanager.dto.auth.RegisterResponse;
import com.danilo.coinmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        try {
            response = userService.saveUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}
