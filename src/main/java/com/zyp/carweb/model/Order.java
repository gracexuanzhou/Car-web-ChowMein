package com.zyp.carweb.model;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer goodsId;

    private Integer userId;

    private Integer status;

    private Integer days;

    private Date createTime;

    private Date updateTime;

    public Order(Integer id, Integer goodsId, Integer userId, Integer status, Integer days, Date createTime, Date updateTime) {
        this.id = id;
        this.goodsId = goodsId;
        this.userId = userId;
        this.status = status;
        this.days = days;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
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