package com.zyp.carweb.command;

import com.alibaba.fastjson.JSONObject;
import com.zyp.carweb.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Receiver {

    public void saveGoodsLog(Goods goods){
        System.out.println("保存产品："+ JSONObject.toJSONString(goods));
    }

    public void buy(){
        String name = "ABC";
        int quantity = 10;
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        String name = "ABC";
        int quantity = 10;
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }

    public void mai(){
        String name = "ABC";
        int quantity = 10;
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void mai(String name,int quantity){
         name = "ABC";
         quantity = 10;
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
