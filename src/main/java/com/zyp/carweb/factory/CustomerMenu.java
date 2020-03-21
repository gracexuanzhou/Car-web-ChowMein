package com.zyp.carweb.factory;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CustomerMenu extends Menu {

    @Override
    public List<JSONObject> produce() {
        List<JSONObject> menuList = new ArrayList<>();
        //顾客
        JSONObject menu = new JSONObject();
        menu.put("text","商品列表");
        menu.put("url","/customer");
        menuList.add(menu);
        menu = new JSONObject();
        menu.put("text","订单管理");
        menu.put("url","/order");
        menuList.add(menu);
        return menuList;
    }
}
