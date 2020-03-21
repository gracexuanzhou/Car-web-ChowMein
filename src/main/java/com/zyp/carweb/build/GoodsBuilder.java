package com.zyp.carweb.build;

import com.zyp.carweb.model.Goods;
import com.zyp.carweb.vo.GoodsVo;

public interface GoodsBuilder {
    void buildGoods1(Goods goods);
    void buildGoods2(String createrName);
    GoodsVo retrieveResult();
}
