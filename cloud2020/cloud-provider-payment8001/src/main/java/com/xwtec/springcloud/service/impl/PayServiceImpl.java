package com.xwtec.springcloud.service.impl;

import com.xwtec.springcloud.Dao.PaymentDao;
import com.xwtec.springcloud.entities.Payment;
import com.xwtec.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
       return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
       return paymentDao.getPaymentById(id);
    }

}
