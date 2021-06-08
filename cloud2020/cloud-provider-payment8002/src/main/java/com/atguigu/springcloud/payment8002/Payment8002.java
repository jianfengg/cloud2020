package com.atguigu.springcloud.payment8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 11:34
 * @UpdateDate: 2021/5/26 11:34
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class);
    }
}
