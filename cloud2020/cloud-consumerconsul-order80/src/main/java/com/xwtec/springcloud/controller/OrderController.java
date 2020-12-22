package com.xwtec.springcloud.controller;

import com.xwtec.springcloud.entities.CommonResult;
import com.xwtec.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL="http://cloud-providerconsul-service";//注册名字
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String create(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
