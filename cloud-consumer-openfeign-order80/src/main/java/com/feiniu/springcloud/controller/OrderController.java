package com.feiniu.springcloud.controller;

import com.feiniu.springcloud.entities.CommonResult;
import com.feiniu.springcloud.entities.Payment;
import com.feiniu.springcloud.service.PaymentOpenfeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxin
 * @Date 2020/9/8 21:39
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 * <p>
 * http://www.rt-mart.com
 * <p>
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
@RestController
public class OrderController {

    @Autowired
    private PaymentOpenfeignService paymentService;

    @GetMapping(value = "/consumer/payment/get/{id}",produces = "application/json; charset=UTF-8")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

}
