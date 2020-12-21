package com.feiniu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * @author liuxin
 * @Date 2020/9/17 20:14
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 * <p>
 * http://www.rt-mart.com
 * <p>
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
@Component
@Slf4j
public class GatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******************  come in"+new Date());

        String username = exchange.getRequest().getQueryParams().getFirst("username");

        if (StringUtils.isBlank(username)) {//如果不符合条件则不放行
            log.info("*******************用户名为null");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        //放行
        return chain.filter(exchange);
    }

    /**
     * 过滤器执行的优先级
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
