package com.zyp.carweb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyp.carweb.build.ConcreteBuilder;
import com.zyp.carweb.build.Director;
import com.zyp.carweb.build.GoodsBuilder;
import com.zyp.carweb.command.Command;
import com.zyp.carweb.command.Invoker;
import com.zyp.carweb.command.LogCommand;
import com.zyp.carweb.command.Receiver;
import com.zyp.carweb.dao.GoodsMapper;
import com.zyp.carweb.dao.UserMapper;
import com.zyp.carweb.model.Goods;
import com.zyp.carweb.model.User;
import com.zyp.carweb.service.GoodsService;
import com.zyp.carweb.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserMapper userMapper;

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
        Receiver receiver = new Receiver();
        Command command = new LogCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setLogCommand(command);
        invoker.goodsLog(goods);
        return goodsMapper.insertSelective(goods);
    }

    @Override
    public Page<GoodsVo> selectGoodsPage(Page<GoodsVo> page,Map<String, Object> map) {
        int total = goodsMapper.selectGoodsCount(map);
        int size = page.getSize();
        int current = page.getCurrent();
        map.put("start", (current - 1) * size);
        map.put("end", size);
        List<Goods> list = goodsMapper.selectGoodsList(map);
        List<GoodsVo> voList = new ArrayList<>();
        Map<Integer,String> uNameMap = new HashMap<>();
        list.forEach(item ->{
            if(!uNameMap.containsKey(item.getCreator())){
                User user = userMapper.selectByPrimaryKey(item.getCreator());
                uNameMap.put(item.getCreator(),user.getUserName());
            }
            GoodsBuilder builder = new ConcreteBuilder();
            Director director = new Director(builder);
            director.construct(item,uNameMap.get(item.getCreator()));
            voList.add(builder.retrieveResult());
        });
        if (total != 0) {
            page = new Page();
            page.setTotal(total);
            page.setRecords(voList);
            page.setSize(size);
            page.setCurrent(current);
        }
        log.info(JSONObject.toJSONString(page));
        return page;
    }
}
