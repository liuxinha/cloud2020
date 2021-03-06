package com.feiniu.springcloud.controller;

import com.feiniu.springcloud.entities.CommonResult;
import com.feiniu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController {

    //private final static String PAYMENT_URL = "http://localhost:8001";//不集群
    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class, id);
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }
}

