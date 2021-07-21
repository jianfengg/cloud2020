package com.spring.test.service.impl;

import com.spring.test.dao.PaymentDao;
import com.spring.test.entity.Payment;
import com.spring.test.service.PaymentService;
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
        if(id == 2) {
            throw new RuntimeException("id为2");
        }
        return paymentDao.getPaymentById(id);
    }
}
