package com.zyp.carweb.bridge;

import com.zyp.carweb.model.Order;
import com.zyp.carweb.vo.OrderVo;

import java.util.Map;


public abstract class OrderBridge {

    protected  OrderAPI orderAPI;

    protected OrderBridge(OrderAPI orderAPI) {
        this.orderAPI = orderAPI;
    }

    public abstract Map buildOrderParam(OrderVo order);
}
