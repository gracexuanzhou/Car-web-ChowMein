package com.zyp.carweb.build;

import com.zyp.carweb.model.Goods;

public class Director  {

    private GoodsBuilder builder;

    public Director(GoodsBuilder builder) {
        this.builder = builder;
    }

    public void construct(Goods goods, String createName){
        builder.buildGoods1(goods);
        builder.buildGoods2(createName);
    }
}
