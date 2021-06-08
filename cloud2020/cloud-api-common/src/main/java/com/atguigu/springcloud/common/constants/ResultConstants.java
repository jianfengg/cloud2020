package com.atguigu.springcloud.common.constants;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 15:11
 * @UpdateDate: 2021/5/26 15:11
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public abstract class ResultConstants {

    public abstract class ResultCode {

        public static final int SUCCESS_CODE = 200;

        public static final int DEFAULT_ERROR_CODE = 500;
    }

    public abstract class ResultMessage {

        public static final String SUCCESS_MSG = "成功";

        public static final String DEFAULT_ERROR_MSG = "系统错误";
    }
}
