package com.zyp.carweb.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyp.carweb.dao.OrderMapper;
import com.zyp.carweb.model.Goods;
import com.zyp.carweb.model.Order;
import com.zyp.carweb.service.OrderService;
import com.zyp.carweb.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<OrderVo> selectPage(Page<OrderVo> page, Map<String, Object> map) {
        int total = orderMapper.selectCount(map);
        int size = page.getSize();
        int current = page.getCurrent();
        map.put("start", (current - 1) * size);
        map.put("end", size);
        List<OrderVo> list = orderMapper.selectList(map);
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
