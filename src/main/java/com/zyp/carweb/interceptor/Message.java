package com.zyp.carweb.interceptor;


public class Message {
    String type;
    String creator;
    String msg;

    public Message(String type, String creator, String msg) {
        this.type = type;
        this.creator = creator;
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public String getCreator() {
        return creator;
    }

    public String getMsg() {
        return msg;
    }
}
