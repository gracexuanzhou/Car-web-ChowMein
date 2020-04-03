package com.zyp.carweb.interceptor.framework;

import com.zyp.carweb.interceptor.Message;
import com.zyp.carweb.interceptor.framework.Service.NullService;
import com.zyp.carweb.interceptor.framework.Service.Service;
import com.zyp.carweb.interceptor.interceptors.Interceptor;


import java.util.ArrayList;
import java.util.List;


public class Framework {
    private  Dispatcher interceptor_list  ;
    private Service service;//List<Service> services; //List也行

    public Framework(Service serviceImp){
        this();
        service = serviceImp;
    }

    public Framework() {
        interceptor_list = new Dispatcher();
        service = new NullService();
    }

    public void setService(Service service){
        this.service = service;
    }

    public void addInterceptor (Interceptor interceptor){
        interceptor_list.addInterceptor(interceptor);
    }

//    public void addService(Service service){
//        services.add(service);
//    }

    public void iterate_list(Context ctx){
        System.out.println("## 商品信息维护Log: " + (ctx.getType().equals("c")?"新增":"修改") +" #开始#");
        interceptor_list.execute(ctx);
        System.out.println("## 商品信息维护Log: " + (ctx.getType().equals("c")?"新增":"修改") +" #结束#");
    }

    public void event(Message message) {
        Context ctxObj = new Context();
        ctxObj.setType(message.getType());
        ctxObj.setCreator(message.getCreator());
        ctxObj.setMsg(message.getMsg());
        // callback 执行所有的interceptors
        iterate_list(ctxObj);
    }
}
