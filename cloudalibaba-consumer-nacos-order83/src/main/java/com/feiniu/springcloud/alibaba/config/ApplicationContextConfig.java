package com.feiniu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuxin
 * @Date 2020/8/13 16:04
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 * <p>
 * http://www.rt-mart.com
 * <p>
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    //@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
