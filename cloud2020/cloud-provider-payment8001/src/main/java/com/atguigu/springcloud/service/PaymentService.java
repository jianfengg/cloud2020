package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 15:35
 * @UpdateDate: 2021/5/26 15:35
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public interface PaymentService {

    /**
     * 新增
     * @param payment 新增数据
     * @return 插入条数
     */
    int add(Payment payment);

    /**
     * 根据获取数据
     * @param id id
     * @return payment
     */
    Payment getPaymentById(Long id);
}
