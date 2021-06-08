package com.atguigu.springcloud.order80.controller;

import com.atguigu.springcloud.common.common.CommonResult;
import com.atguigu.springcloud.common.entity.payment.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 17:02
 * @UpdateDate: 2021/5/26 17:02
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001/";

    private static final String EUREKA_PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Resource
    private RestTemplate restTemplate;


    /**
     * 自定义负载均衡规则
     */
   /* @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;*/

    @GetMapping("/payment/add")
    public CommonResult add(Payment payment) {
        return this.restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        //指定访问地址
//        return this.restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        //适用eureka 需要在配置文件加上loadbanlance注解进行负载均衡
        return this.restTemplate.getForObject(EUREKA_PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
