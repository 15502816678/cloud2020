package springcloud.service.impl;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import springcloud.service.OrderHystrixService;

@Component
public class OrderHystrixServiceImpl implements FallbackFactory<OrderHystrixService> {

/*    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK=============降级方法";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut=============降级方法";
    }*/

    @Override
    public OrderHystrixService create(Throwable throwable) {
        return new OrderHystrixService(){

            @Override
            public String paymentInfo_OK(Integer id) {
                return "paymentInfo_OK=============降级方法";
            }

            @Override
            public String paymentInfo_TimeOut(Integer id) {
                return "paymentInfo_TimeOut=============降级方法";
            }
        };
    }
}
