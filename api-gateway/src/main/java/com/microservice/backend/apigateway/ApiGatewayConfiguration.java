package com.microservice.backend.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/hello-world/**").uri("http://127.0.0.1:8001/hello-world/"))
                .route(p -> p.path("/python-backend-service/**").uri("http://127.0.0.1:8000/python-backend-service/")
                ).build();
    }
}
