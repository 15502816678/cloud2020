package com.xwtec.springcloud.controller;

import com.xwtec.springcloud.entities.CommonResult;
import com.xwtec.springcloud.service.OrderFeigenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private OrderFeigenService orderFeigenService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        return orderFeigenService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feigntimeout")
    public String OpenFeignTimeOut(){
        return orderFeigenService.OpenFeignTimeOut();
    }
}
