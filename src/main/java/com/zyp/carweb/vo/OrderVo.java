package com.zyp.carweb.vo;

import com.zyp.carweb.model.Order;

import java.math.BigDecimal;

public class OrderVo extends Order {

    private String brandName;
    private String typeName;
    private String location;
    private BigDecimal price;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
