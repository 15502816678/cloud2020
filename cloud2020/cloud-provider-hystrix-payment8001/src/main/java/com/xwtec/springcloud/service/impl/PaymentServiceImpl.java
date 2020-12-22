package com.xwtec.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xwtec.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        if(id < 0){
            throw new RuntimeException("id====不能是负数");
        }
        String num = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功"+num;
        //return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_backfusingOK",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//熔断最低触发请求数阈值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//产生熔断后恢复窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 错误率阈值
    })
    public String paymentInfo_fusingOK(Integer id) {
        if(id < 0){
            throw new RuntimeException("id====不能是负数");
        }
        String num = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"======liushui"+num;
    }
    public String paymentInfo_backfusingOK(Integer id){
        return Thread.currentThread().getName()+"======id不能为负数"+id;
    }
}
