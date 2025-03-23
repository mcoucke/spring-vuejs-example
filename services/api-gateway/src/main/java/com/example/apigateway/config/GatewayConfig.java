package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/auth/**")
                        .filters(f -> f.addRequestHeader("X-Internal-Token", "secretToken"))
                        .uri("http://localhost:8081"))
                .route("person-service", r -> r.path("/person/**")
                        .filters(f -> f.addRequestHeader("X-Internal-Token", "secretToken"))
                        .uri("http://localhost:8082"))
                .route("request-service", r -> r.path("/request/**")
                        .filters(f -> f.addRequestHeader("X-Internal-Token", "secretToken"))
                        .uri("http://localhost:8083"))
                .build();
    }
}