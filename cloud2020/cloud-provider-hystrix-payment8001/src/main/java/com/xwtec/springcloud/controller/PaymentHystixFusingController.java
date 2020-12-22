package com.xwtec.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.xwtec.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentHystixFusingController {
    @Resource
    private PaymentService paymentService;
    //服务熔断
    @GetMapping("/payment/hystrix_fusing/{id}")
    public String paymentInfo_fusingOK(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_fusingOK(id);
    }
}
