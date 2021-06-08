package com.atguigu.springcloud.payment8002.service.impl;

import com.atguigu.springcloud.payment8002.dao.PaymentDao;
import com.atguigu.springcloud.payment8002.entity.Payment;
import com.atguigu.springcloud.payment8002.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 15:36
 * @UpdateDate: 2021/5/26 15:36
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
