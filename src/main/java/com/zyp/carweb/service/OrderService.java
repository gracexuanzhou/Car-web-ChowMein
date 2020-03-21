package com.zyp.carweb.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyp.carweb.model.Goods;
import com.zyp.carweb.model.Order;
import com.zyp.carweb.vo.OrderVo;

import java.util.Map;

public interface OrderService {

    int insertSelective(Order record);

    int updateByPrimaryKeySelective(Order record);

    Order selectByPrimaryKey(Integer id);

    Page<OrderVo> selectPage(Page<OrderVo> page, Map<String, Object> map);
}
