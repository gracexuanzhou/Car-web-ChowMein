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

    public void construct(Goods goods){
        builder.buildGoods1(goods);
    }

    public void construct(String createName){
        builder.buildGoods2(createName);
    }

    public void construct(Goods goods, String createName,Integer type,Integer age){
        builder.buildGoods1(goods);
        builder.buildGoods2(createName);
    }

    public void construct(Goods goods, String createName,String name){
        builder.buildGoods1(goods);
        builder.buildGoods2(createName);
    }

    public void construct(Goods goods, String createName,Integer age){
        builder.buildGoods1(goods);
        builder.buildGoods2(createName);
    }

}
