package com.atguigu.springcloud.payment8002.service;

import com.atguigu.springcloud.payment8002.entity.Payment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/6/7 17:03
 * @UpdateDate: 2021/6/7 17:03
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    void getPaymentById() {
        Payment paymentById = paymentService.getPaymentById(1L);
        System.out.println(paymentById);
    }
}