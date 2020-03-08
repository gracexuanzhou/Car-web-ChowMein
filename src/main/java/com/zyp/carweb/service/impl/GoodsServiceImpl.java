package com.zyp.carweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyp.carweb.dao.GoodsMapper;
import com.zyp.carweb.model.Goods;
import com.zyp.carweb.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods selectByPrimaryKey(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveGoods(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    @Override
    public Page<Goods> selectGoodsPage(Page<Goods> page,Map<String, Object> map) {
        int total = goodsMapper.selectGoodsCount(map);
        int size = page.getSize();
        int current = page.getCurrent();
        map.put("start", (current - 1) * size);
        map.put("end", size);
        List<Goods> list = goodsMapper.selectGoodsList(map);
        if (total != 0) {
            page = new Page();
            page.setTotal(total);
            page.setRecords(list);
            page.setSize(size);
            page.setCurrent(current);
        }
        return page;
    }
}
