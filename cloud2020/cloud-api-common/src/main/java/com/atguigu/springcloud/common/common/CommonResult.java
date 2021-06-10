package com.atguigu.springcloud.common.common;

import com.atguigu.springcloud.common.constants.ResultConstants;

import java.io.Serializable;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/26 15:09
 * @UpdateDate: 2021/5/26 15:09
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class CommonResult<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(T data) {
        this.code = ResultConstants.ResultCode.SUCCESS_CODE;
        this.data = data;
    }

    public CommonResult(Integer code, T data) {
        this.code = code;
        this.data = data;
        this.message = ResultConstants.ResultMessage.SUCCESS_MSG;
    }

    public CommonResult() {
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
