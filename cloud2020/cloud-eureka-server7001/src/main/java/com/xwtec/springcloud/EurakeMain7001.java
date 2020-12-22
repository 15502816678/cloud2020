package com.xwtec.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakeMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurakeMain7001.class,args);
    }
}
