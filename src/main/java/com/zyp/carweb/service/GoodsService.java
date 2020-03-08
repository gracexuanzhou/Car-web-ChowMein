package com.zyp.carweb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyp.carweb.model.Goods;

import java.util.Map;

public interface GoodsService {

    int saveGoods(Goods goods);

    Page<Goods> selectGoodsPage(Page<Goods> page, Map<String, Object> map);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods goods);

    int deleteByPrimaryKey(Integer id);

}