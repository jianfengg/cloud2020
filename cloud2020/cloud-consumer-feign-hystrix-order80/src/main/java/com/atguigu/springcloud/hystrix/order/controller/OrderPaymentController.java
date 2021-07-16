package com.atguigu.springcloud.hystrix.order.controller;

import com.atguigu.springcloud.common.common.CommonResult;
import com.atguigu.springcloud.common.entity.payment.Payment;
import com.atguigu.springcloud.hystrix.order.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")v
public class OrderPaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentById111", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000")
    })
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        //指定访问地址
        //适用eureka 需要在配置文件加上loadbanlance注解进行负载均衡
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("等待", e);
        }
        log.info("不等了");
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/testTimeOut")
//    @HystrixCommand(fallbackMethod = "paymentGlobalFallbackMethod", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "6000")
//    })
    @HystrixCommand(fallbackMethod = "paymentGlobalFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000")
    })
    public CommonResult<String> testTimeOut() {
        try {
            return this.paymentService.testTimeOut();
        } catch (Exception e) {
            log.error("异常", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 全局fallback
     *
     * @return
     */
    public CommonResult<String> paymentGlobalFallbackMethod() {
        return new CommonResult<>("Global异常处理信息,请稍后重试.o(╥﹏╥)o");
    }


    public CommonResult<Payment> getPaymentById111(Long id) {
        return new CommonResult<>(new Payment());
    }
}
