package com.samjain.plroject.Gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->
                        r.path("/crud/**")
                                .uri("http:/localhost:8760")
                )
                .route( r-> r.path("/second/**")
                        .uri("http://localhost:8761")
                )
                .build();
    }
}