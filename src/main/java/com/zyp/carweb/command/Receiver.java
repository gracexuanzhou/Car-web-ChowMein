package com.zyp.carweb.command;

import com.alibaba.fastjson.JSONObject;
import com.zyp.carweb.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Receiver {

    public void saveGoodsLog(Goods goods){
        System.out.println("保存产品："+ JSONObject.toJSONString(goods));
    }
}
