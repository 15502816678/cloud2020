package com.xwtec.springcloud.MyLB.MyLBImpl;

import com.xwtec.springcloud.MyLB.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写请求轮询方法
 */
@Component
public class LoadBalancedImpl implements LoadBalanced
{

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    public final int getIncrementAndGetModulo(){
        int current ;
        int next ;
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current +1;
        }while (!this.atomicInteger.compareAndSet(current,next));

        return next;
    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> instance) {
        int index = getIncrementAndGetModulo() % instance.size();

        return instance.get(index);
    }
}
