package com.zyp.carweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;

    private String brandName;

    private String typeName;

    private BigDecimal price;

    private String place;

    private String location;

    private Integer creator;

    private Date createTime;

    private Date updateTime;
    public Goods(Integer id, String brandName, String typeName, BigDecimal price, String place, String location, Integer creator, Date createTime, Date updateTime) {
        this.id = id;
        this.brandName = brandName;
        this.typeName = typeName;
        this.price = price;
        this.place = place;
        this.location = location;
        this.creator = creator;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Goods() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
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