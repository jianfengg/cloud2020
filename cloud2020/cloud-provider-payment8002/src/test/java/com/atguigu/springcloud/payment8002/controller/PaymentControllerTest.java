package com.atguigu.springcloud.payment8002.controller;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/6/7 17:13
 * @UpdateDate: 2021/6/7 17:13
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentControllerTest {

    //启用web上下文
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before()
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @org.junit.jupiter.api.Test
    public void hello() throws Exception {
        // 得到MvcResult自定义验证
        // 执行请求
        MvcResult mvcResult= mvc.perform(MockMvcRequestBuilders.get("/hello")
                //.post("/hello") 发送post请求
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                //传入参数
                .param("name","longzhonghua")
                // .accept(MediaType.TEXT_HTML_VALUE))
                //接收的类型
                .accept(MediaType.APPLICATION_JSON_UTF8))
                //等同于Assert.assertEquals(200,status);
                //判断接收到的状态是否是200
                .andExpect(MockMvcResultMatchers.status().isOk())
                //等同于 Assert.assertEquals("hello longzhonghua",content);
                .andExpect(MockMvcResultMatchers.content().string("hello longzhonghua"))
                .andDo(MockMvcResultHandlers.print())
                //返回MvcResult
                .andReturn();
        //得到返回代码
        int status=mvcResult.getResponse().getStatus();
        //得到返回结果
        String content=mvcResult.getResponse().getContentAsString();
        //断言，判断返回代码是否正确
        Assert.assertEquals(200,status);
        //断言，判断返回的值是否正确
        Assert.assertEquals("hello longzhonghua",content);
    }

    @Test
    public void updateLearn() throws Exception{
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/payment/get/1")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        System.out.println(JSON.toJSONString(resultActions));

//        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/payment/get/1"));
//
//        System.out.println(JSON.toJSONString(resultActions));
    }

}