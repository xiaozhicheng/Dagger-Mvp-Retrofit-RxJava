package com.cxz.mvpdemo.http;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-30
 * Time: 11:26
 */
public class HttpResult<T> {

    private int code;

    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
