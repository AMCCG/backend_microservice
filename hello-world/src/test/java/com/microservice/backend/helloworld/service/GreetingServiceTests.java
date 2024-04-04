package com.microservice.backend.helloworld.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreetingServiceTests {
    @Autowired
    GreetingService greetingService;

    @Test
    void testGreeting() {

        // Given
        String expected = "Hello World";

        // When
        String actual = greetingService.greeting(true);

        // Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testException() {

        // Given
        Class<NullPointerException> expected = NullPointerException.class;

        // When
        Executable executable = () -> greetingService.greeting(false);

        // Then
        Assertions.assertThrows(expected, executable);
    }

}
