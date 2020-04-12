package com.zyp.carweb.bridge;

import com.zyp.carweb.model.Order;
import com.zyp.carweb.vo.OrderVo;

import java.util.HashMap;
import java.util.Map;


public class MerchantOrder implements OrderAPI {

    @Override
    public Map getOrder(OrderVo order) {
        Map<String, Object> map = new HashMap<>();
        return map;
    }
}
