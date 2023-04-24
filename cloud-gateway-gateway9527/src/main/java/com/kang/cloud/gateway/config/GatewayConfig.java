package com.kang.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: KX
 * @Description: 以代码的形式配置路由
 * @DateTime: 2023/4/24
 * @Version 1.0
 */

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("payment_route2",
                r -> r.path("/payment/discovery").uri("http://localhost:8001/payment/discovery")).build();

        return routes.build();
    }
}
