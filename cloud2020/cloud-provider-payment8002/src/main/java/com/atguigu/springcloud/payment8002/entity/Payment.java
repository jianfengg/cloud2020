package com.atguigu.springcloud.payment8002.entity;

import lombok.Data;

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
@Data
public class Payment extends BaseEntity{
    public Payment() {
    }

    private String serial;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "serial='" + serial + '\'' +
                '}';
    }
}
