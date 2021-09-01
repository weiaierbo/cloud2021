package com.xxt.dto;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author xk
 * @create 2021.08.04 19:54
 */
@Getter
public class CommonResult <T> implements Serializable {

    private Integer code;

    private T data;

    private String message;

    public CommonResult() {
    }

    public CommonResult(T data) {
        this.data = data;
    }

    public CommonResult(T data,String message) {
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> buildSuccessData(T data){
        CommonResult result = new CommonResult(data);
        result.code=0;
        return result;
    }

    public static <T> CommonResult buildSuccessMessage(String message){
        CommonResult result = new CommonResult();
        result.code=0;
        result.message = message;
        return result;
    }

    public static CommonResult buildErrorMessage(String message){
        CommonResult result = new CommonResult();
        result.code=-1;
        result.message = message;
        return result;
    }
}
