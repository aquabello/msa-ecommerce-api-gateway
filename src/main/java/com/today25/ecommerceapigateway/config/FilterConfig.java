package com.today25.ecommerceapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

    /**
     * Filter
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        r -> r.path("/order/**")
                                .filters(
                                        f -> f.addRequestHeader("order-request", "order-request-header")
                                                .addResponseHeader("order-response", "order-response-header")
                                )
                                .uri("http://localhost:8081")
                )
                .route(
                        r -> r.path("/member/**")
                                .filters(
                                        f -> f.addRequestHeader("member-request", "member-request-header")
                                                .addResponseHeader("member-response", "member-response-header")
                                )
                                .uri("http://localhost:8082")
                )
                .build();
    }

}
