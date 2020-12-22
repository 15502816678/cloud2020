package springcloud.service.impl;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import springcloud.service.PaymentHystrixFusingService;

@Component
public class PaymentHystrixFusingServiceImpl implements FallbackFactory<PaymentHystrixFusingService>{

/**
 * 服务降级处理类，该类需要实现FallbackFactory接口
 * 其泛型为服务降级所对应的Feign接口
*/
    @Override
    public PaymentHystrixFusingService create(Throwable throwable) {

        return new PaymentHystrixFusingService(){

            @Override
            public String paymentInfo_fusingOK(Integer id) {
                return "============降级熔断";
            }
        };
    }
}
