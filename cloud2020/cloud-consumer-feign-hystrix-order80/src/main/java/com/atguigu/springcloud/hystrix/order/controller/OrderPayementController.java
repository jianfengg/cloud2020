package com.atguigu.springcloud.hystrix.order.controller;

import com.atguigu.springcloud.common.common.CommonResult;
import com.atguigu.springcloud.common.entity.payment.Payment;
import com.atguigu.springcloud.hystrix.order.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/6/10 10:41
 * @UpdateDate: 2021/6/10 10:41
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderPayementController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        //指定访问地址
        //适用eureka 需要在配置文件加上loadbanlance注解进行负载均衡
        return paymentService.getPaymentById(id);
    }
}
