package com.xwtec.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    /**
     * 代码端配置gateway
     * @param builder
     * @return
     */
    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes().
                route("gateway-xwtec1",j -> j.path("/guonei").uri("http://news.baidu.com"))
                .build();
    }
}
