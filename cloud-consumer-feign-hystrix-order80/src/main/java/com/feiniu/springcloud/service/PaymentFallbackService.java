package com.feiniu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Date 2020/9/10 11:06
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 * <p>
 * http://www.rt-mart.com
 * <p>
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "我是PaymentHystrixService paymentInfo_OK的兜底方法o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "我是PaymentHystrixService paymentInfo_TimeOut的兜底方法(╥﹏╥)o";
    }
}
