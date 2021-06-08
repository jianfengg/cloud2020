package com.atguigu.springcloud.eureka7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/6/3 16:31
 * @UpdateDate: 2021/6/3 16:31
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7002.class, args);
    }
}
