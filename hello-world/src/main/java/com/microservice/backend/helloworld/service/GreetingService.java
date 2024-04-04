package com.microservice.backend.helloworld.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greeting(boolean isValid) {
        if (!isValid) {
            throw new NullPointerException();
        }
        return "Hello World";
    }
}
