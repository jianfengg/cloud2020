package com.atguigu.springcloud.feign.service;

import com.atguigu.springcloud.common.common.CommonResult;
import com.atguigu.springcloud.common.entity.payment.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/6/9 16:09
 * @UpdateDate: 2021/6/9 16:09
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {


    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

}
