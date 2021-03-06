package com.feiniu.springcloud.controller;

import com.feiniu.springcloud.entities.CommonResult;
import com.feiniu.springcloud.entities.Payment;
import com.feiniu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String SERVER_PORT;

    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功，serverPort：" + SERVER_PORT, result);
        } else {
            return new CommonResult(444, "插入失败" + SERVER_PORT, null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) throws InterruptedException {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查询结果"+payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，serverPort"+SERVER_PORT, payment);
        } else {
            return new CommonResult(444, "没有记录", null);
        }

    }


    @GetMapping("/payment/discovery")
    public Object discovery() {
        //获得注册到Eureka上的所有服务名称
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*******element："+element);
        }

        //得到CLOUD-PAYMENT-SERVICE服务上的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t" +instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }


    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hello zipkin";
    }
}
