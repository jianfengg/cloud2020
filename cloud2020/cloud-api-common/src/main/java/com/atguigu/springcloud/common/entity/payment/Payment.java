package com.atguigu.springcloud.common.entity.payment;

import com.atguigu.springcloud.common.entity.BaseEntity;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 15:06
 * @UpdateDate: 2021/5/26 15:06
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class Payment extends BaseEntity {

    private String serial;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
