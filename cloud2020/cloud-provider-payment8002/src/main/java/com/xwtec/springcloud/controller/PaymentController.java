package com.xwtec.springcloud.controller;

import com.xwtec.springcloud.entities.CommonResult;
import com.xwtec.springcloud.entities.Payment;
import com.xwtec.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("-----插入结果==="+result);
        if(result > 0){
            return new CommonResult(200,"插入成功,serverPort=="+serverPort,result);
        }else {
            return new CommonResult(444,"插入失败",null);

        }
    }
    /*
            @PathVariable是spring3.0的一个新功能：接收请求路径中占位符的值
            @RequestParam 和 @PathVariable 注解是用于从request中接收请求的，两个都可以接收参数，
            关键点不同的是@RequestParam 是从request里面拿取值，而 @PathVariable 是从一个URI模板里面来填充
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("-----查询结果==="+payment+"hahah");
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort=="+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败,查询id="+id,null);

        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
    @GetMapping(value = "/payment/feigntimeout")
    public String OpenFeignTimeOut() {
        try {
            log.info("=============测试超时");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
