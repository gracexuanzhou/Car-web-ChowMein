package com.zyp.carweb.bridge;

import com.zyp.carweb.model.Order;
import com.zyp.carweb.vo.OrderVo;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;


public class CustomerOrder implements OrderAPI {

    @Override
    public Map getOrder(OrderVo order) {
        Map<String, Object> map = new HashMap<>();
        map.put("creator",order.getUserId());
        if(StringUtils.isEmpty(order.getBrandName())){
            map.put("brandName",order.getBrandName());
        }
        if(order.getMaxPrice() != null){
            map.put("maxPrice",order.getMaxPrice());
        }
        if(order.getMinPrice() != null){
            map.put("minPrice()",order.getMinPrice());
        }
        return map;
    }
}
