package com.zyp.carweb.base;

import java.io.Serializable;

public class SSOUserInfo implements Serializable {


    private static final long serialVersionUID = 1L;
    private int id;//编号
    private String loginName;//登录名
    private String userName;//用户名
    private Integer userType;//用户类型()
    private String operateIp;

    public SSOUserInfo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }
}
