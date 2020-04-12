package com.zyp.carweb.bridge;

import com.zyp.carweb.model.Order;
import com.zyp.carweb.vo.OrderVo;

import java.util.Map;


public interface OrderAPI {
    public Map getOrder(OrderVo order);
}
