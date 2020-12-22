package com.xwtec.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class GateFilter implements GlobalFilter,Ordered{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       String name =  exchange.getRequest().getQueryParams().getFirst("name");
       if(null == name){
           log.info("===========非法进入");
           exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
           return exchange.getResponse().setComplete();
       }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
