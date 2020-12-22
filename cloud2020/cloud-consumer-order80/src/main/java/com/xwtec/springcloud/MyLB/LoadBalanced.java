package com.xwtec.springcloud.MyLB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalanced {
    ServiceInstance instance(List<ServiceInstance> instance);
}
