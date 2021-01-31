package com.feiniu.alibabacloud.service;

import com.feiniu.springcloud.entities.Payment;

/**
 * @author liuxin
 * @Date 2020/8/13 14:49
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 * <p>
 * http://www.rt-mart.com
 * <p>
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
