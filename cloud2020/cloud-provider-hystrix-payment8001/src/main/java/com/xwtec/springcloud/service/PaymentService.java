package com.xwtec.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {

    public String paymentInfo_OK(@PathVariable("id") Integer id);

    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);

    public String paymentInfo_fusingOK(@PathVariable("id") Integer id);
}
