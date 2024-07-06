package com.microservice.backend.userservice.controller;

import com.microservice.backend.userservice.clientservice.UserClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user-service")
@AllArgsConstructor
public class UserController {

    private final UserClientService userClientService;

    @GetMapping("/users")
    public ResponseEntity<String> getAllUser() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:8080/v1/user-service/users", String.class);
        return ResponseEntity.ok("hello-world => " + responseEntity.getBody());
    }

    @GetMapping("/users-feign")
    public ResponseEntity<String> getAllUserWithFeign() {
        String result = userClientService.getUsers(new HttpHeaders());
        return ResponseEntity.ok("hello-world-feign => " + result);
    }

    @GetMapping("/users-rest")
    public ResponseEntity<String> getAllUserWithRestClient() {
        RestClient customClient = RestClient.builder().build();
        String result = customClient.get().uri("http://127.0.0.1:8080/v1/user-service/users").retrieve().body(String.class);
        return ResponseEntity.ok("hello-world-rest-client => " + result);
    }
}
