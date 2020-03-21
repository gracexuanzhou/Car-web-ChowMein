package com.zyp.carweb.build;

import com.zyp.carweb.model.Goods;
import com.zyp.carweb.vo.GoodsVo;
import org.springframework.beans.BeanUtils;

public class ConcreteBuilder implements GoodsBuilder {

    private GoodsVo goodsVo = new GoodsVo();

    @Override
    public void buildGoods1(Goods goods) {
        BeanUtils.copyProperties(goods,goodsVo);
    }

    @Override
    public void buildGoods2(String createrName) {
        goodsVo.setCreateName(createrName);
    }

    @Override
    public GoodsVo retrieveResult() {
        return goodsVo;
    }
}
