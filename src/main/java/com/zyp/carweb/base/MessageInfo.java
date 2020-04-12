package com.zyp.carweb.base;

import java.io.Serializable;

public class MessageInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String message = "Successful Operation";
    private int code = 0;
    private Object result;

    public MessageInfo() {
    }

    public MessageInfo(Object result) {
        this.result = result;
    }

    public MessageInfo(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public MessageInfo(String message, int code, Object result) {
        this.message = message;
        this.code = code;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public MessageInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public MessageInfo setCode(int code) {
        this.code = code;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public MessageInfo setResult(Object result) {
        this.result = result;
        return this;
    }

}
