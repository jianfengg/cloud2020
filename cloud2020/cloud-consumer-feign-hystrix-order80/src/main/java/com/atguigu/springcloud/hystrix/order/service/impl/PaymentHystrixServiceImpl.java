package com.atguigu.springcloud.hystrix.order.service.impl;

import com.atguigu.springcloud.common.common.CommonResult;
import com.atguigu.springcloud.common.entity.payment.Payment;
import com.atguigu.springcloud.hystrix.order.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/6/10 11:19
 * @UpdateDate: 2021/6/10 11:19
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */

@Service
public class PaymentHystrixServiceImpl implements PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentHystrixServiceImpl.class);

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        log.info("getPaymentById..............降级");
        return new CommonResult<>(new Payment());
    }

    @Override
    public CommonResult<String> testTimeOut() {
        log.info("testTimeOut..............降级");
        return new CommonResult<>("出错咯");
    }
}
