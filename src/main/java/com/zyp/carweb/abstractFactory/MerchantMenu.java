package com.zyp.carweb.abstractFactory;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MerchantMenu extends AbstractMenu {

    @Override
    public List<JSONObject> produce() {
        List<JSONObject> menuList = new ArrayList<>();
        JSONObject menu = new JSONObject();
        menu.put("text","商品管理");
        menu.put("url","/merchant");
        menuList.add(menu);
        menu = new JSONObject();
        menu.put("text","订单管理");
        menu.put("url","/merchant/order");
        menuList.add(menu);
        return menuList;
    }
}
