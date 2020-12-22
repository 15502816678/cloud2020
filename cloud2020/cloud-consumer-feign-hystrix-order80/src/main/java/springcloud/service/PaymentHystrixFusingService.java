package springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.service.impl.PaymentHystrixFusingServiceImpl;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallbackFactory =PaymentHystrixFusingServiceImpl.class)
public interface PaymentHystrixFusingService {
    @GetMapping("/payment/hystrix_fusing/{id}")
    public String paymentInfo_fusingOK(@PathVariable("id") Integer id);
}
