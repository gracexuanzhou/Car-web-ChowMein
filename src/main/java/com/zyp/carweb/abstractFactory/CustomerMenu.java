package com.zyp.carweb.abstractFactory;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CustomerMenu extends AbstractMenu {

    @Override
    public List<JSONObject> produce() {
        List<JSONObject> menuList = new ArrayList<>();
        //顾客
        JSONObject menu = new JSONObject();
        menu.put("text","Product List");
        menu.put("url","/customer");
        menuList.add(menu);
        menu = new JSONObject();
        menu.put("text","Order Management");
        menu.put("url","/order");
        menuList.add(menu);
        return menuList;
    }
}
