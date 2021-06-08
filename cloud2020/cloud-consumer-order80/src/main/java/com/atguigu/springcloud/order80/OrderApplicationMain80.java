package com.atguigu.springcloud.order80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/5/26 16:58
 * @UpdateDate: 2021/5/26 16:58
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApplicationMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationMain80.class);
    }
}
