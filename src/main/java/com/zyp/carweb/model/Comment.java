package com.zyp.carweb.model;

import java.util.Date;

public class Comment {
    private Integer id;

    private String content;

    private String userName;

    private Integer goodsId;

    private Integer orderId;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    public Comment(Integer id, String content, String userName, Integer goodsId, Integer orderId, Integer userId, Date createTime, Date updateTime) {
        this.id = id;
        this.content = content;
        this.userName = userName;
        this.goodsId = goodsId;
        this.orderId = orderId;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}