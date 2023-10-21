package com.spring.app1.entity;

public class Response <T> {
    private T result;
    private int code;

    Response(T result, int code){
        this.result = result;
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static <T> Response<T> create(T result, int code) {
        return new Response<T>(result, code);
    }
}
