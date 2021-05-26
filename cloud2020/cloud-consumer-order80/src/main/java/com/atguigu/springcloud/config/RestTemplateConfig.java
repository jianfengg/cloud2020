package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 17:00
 * @UpdateDate: 2021/5/26 17:00
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplateConfig() {
        return new RestTemplate();
    }
}
