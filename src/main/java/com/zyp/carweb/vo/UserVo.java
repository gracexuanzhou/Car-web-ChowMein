package com.zyp.carweb.vo;

import com.zyp.carweb.model.User;

public class UserVo extends User {
    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
