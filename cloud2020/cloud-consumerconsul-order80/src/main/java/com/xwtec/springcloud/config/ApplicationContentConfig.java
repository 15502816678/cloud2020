package com.xwtec.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
 */
@Configuration
public class ApplicationContentConfig {
    @Bean
    @LoadBalanced //使用这个注解赋予RestTemplate 负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
