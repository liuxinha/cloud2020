package com.feiniu.alibabacloud.service.impl;

import com.feiniu.alibabacloud.dao.PaymentMapper;
import com.feiniu.alibabacloud.service.PaymentService;
import com.feiniu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxin
 * @Date 2020/8/13 14:50
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 * <p>
 * http://www.rt-mart.com
 * <p>
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
