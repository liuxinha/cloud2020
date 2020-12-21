package com.feiniu.springcloud.dao;

import com.feiniu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuxin
 * @Date 2020/8/13 14:35
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 * <p>
 * http://www.rt-mart.com
 * <p>
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
