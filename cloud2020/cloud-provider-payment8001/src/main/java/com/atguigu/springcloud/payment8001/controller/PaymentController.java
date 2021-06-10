package com.atguigu.springcloud.payment8001.controller;

import com.atguigu.springcloud.common.common.CommonResult;
import com.atguigu.springcloud.common.constants.ResultConstants;
import com.atguigu.springcloud.payment8001.entity.Payment;
import com.atguigu.springcloud.payment8001.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 15:37
 * @UpdateDate: 2021/5/26 15:37
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/add")
    public CommonResult<Integer> add(@RequestBody Payment payment) {
        log.info("进入新增方法>>");
        int add = this.paymentService.add(payment);
        return new CommonResult<>(ResultConstants.ResultCode.SUCCESS_CODE, "写入成功", add);
    }


    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("当前线程,{}", Thread.currentThread());
        log.info("根据ID获取数据");
        Payment payment = paymentService.getPaymentById(id);
        CommonResult<Payment> commonResult = new CommonResult<>(ResultConstants.ResultCode.SUCCESS_CODE, "访问port: " + serverPort + " 数据：" + payment);
        log.info(commonResult.toString());
        return commonResult;
    }

    @GetMapping("/testTimeOut")
    public CommonResult<String> testTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("异常",e);
        }
        return new CommonResult<>(serverPort);
    }
}
