package com.zyp.carweb.bridge;

import com.zyp.carweb.model.Order;
import com.zyp.carweb.vo.OrderVo;

import java.util.Map;


public class OrderParams extends OrderBridge {


    public OrderParams(OrderAPI orderAPI) {
        super(orderAPI);
    }

    @Override
    public Map buildOrderParam(OrderVo order) {
        return orderAPI.getOrder(order);
    }
}
