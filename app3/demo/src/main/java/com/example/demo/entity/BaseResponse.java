package com.example.demo.entity;

public class BaseResponse {

    private int code;
    private Object result;
    private String errMsg;

    public BaseResponse(int code, Object result, String errMsg) {
        this.code = code;
        this.result = result;
        this.errMsg = errMsg;
    }


    public static BaseResponse create(int code, Object result, String errMsg) {
        return new BaseResponse(code, result, errMsg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }



    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
