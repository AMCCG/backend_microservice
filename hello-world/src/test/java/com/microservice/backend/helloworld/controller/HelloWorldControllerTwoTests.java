package com.microservice.backend.helloworld.controller;

import com.microservice.backend.helloworld.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({HelloWorldController.class})
class HelloWorldControllerTwoTests {

    @MockBean
    private GreetingService greetingService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testIndexEndpoint() throws Exception {
        // Mock
        when(greetingService.greeting(true)).thenReturn("Hello World");

        // Given
        String endpoint = "/hello-world/greeting";

        // When
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk()).andExpect(content().string(containsString("Hello World")));
        verify(greetingService, times(1)).greeting(true);
    }


}