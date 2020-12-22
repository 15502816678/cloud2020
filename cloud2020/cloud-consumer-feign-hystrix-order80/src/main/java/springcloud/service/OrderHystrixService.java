package springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.service.impl.OrderHystrixServiceImpl;


@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE" ,fallbackFactory = OrderHystrixServiceImpl.class)
/**
 * fallback 出现运行时错误  超时 宕机  进行服务降级 执行OrderHystrixServiceImpl 重写的方法
 */
public interface OrderHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
