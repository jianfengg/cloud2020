package com.atguigu.springcloud.payment8001.dao;

import com.atguigu.springcloud.payment8001.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 15:21
 * @UpdateDate: 2021/5/26 15:21
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Mapper
public interface PaymentDao {

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
    Payment getPaymentById(@Param("id") Long id);
}
