package com.microservice.backend.helloworld.controller;

import com.microservice.backend.helloworld.dto.InformationResponse;
import com.microservice.backend.helloworld.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    private final GreetingService greetingService;
    private final Environment environment;

    @Autowired
    public HelloWorldController(GreetingService greetingService, Environment environment) {
        this.greetingService = greetingService;
        this.environment = environment;
    }

    @GetMapping("/greeting")
    public ResponseEntity<InformationResponse> getGreeting() throws UnknownHostException {
        String host = Optional.ofNullable(environment.getProperty("HOSTNAME")).orElse(InetAddress.getLocalHost().getHostName());
        String version = "v1";
        String greeting = greetingService.greeting(true);
        InformationResponse information = InformationResponse.builder().hostName(host).version(version).greeting(greeting).build();
        return ResponseEntity.ok(information);
    }

}
