package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.OrderHystrixService;
import springcloud.service.PaymentHystrixFusingService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @Resource
    private PaymentHystrixFusingService paymentHystrixFusingService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    //@HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return orderHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   // @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return orderHystrixService.paymentInfo_TimeOut(id);

    }

    /**
     * 服务熔段
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix_fusing/{id}")
    public String paymentInfo_fusingOK(@PathVariable("id") Integer id){
        return paymentHystrixFusingService.paymentInfo_fusingOK(id);
    }

}
