package com.feiniu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author liuxin
 * @Date 2020/8/13 14:52
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 * <p>
 * http://www.rt-mart.com
 * <p>
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "payment/zk")
    public String paymentZk() {
        return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
