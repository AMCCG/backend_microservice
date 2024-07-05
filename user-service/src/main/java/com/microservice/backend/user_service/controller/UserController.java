package com.microservice.backend.user_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user-service")
public class UserController {

    @GetMapping("/users")
    public ResponseEntity<String> getAllUser() {
        return ResponseEntity.ok("user-service");
    }
}
