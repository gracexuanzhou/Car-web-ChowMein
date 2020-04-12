package com.zyp.carweb.interceptor.framework;

import com.zyp.carweb.interceptor.Message;
import com.zyp.carweb.interceptor.interceptors.Interceptor;


import java.util.ArrayList;
import java.util.List;


public class Framework {
    private  Dispatcher interceptor_list  ;


    public Framework() {
        interceptor_list = new Dispatcher();
    }


    public void addInterceptor (Interceptor interceptor){
        interceptor_list.addInterceptor(interceptor);
    }

//    public void addService(Service service){
//        services.add(service);
//    }

    public void iterate_list(Context ctx){
        System.out.println("## Product Information Maintenance Log: " + (ctx.getType().equals("c")?"New":"modify") +" #Start#");
        interceptor_list.execute(ctx);
        System.out.println("## Product Information Maintenance Log: " + (ctx.getType().equals("c")?"New":"modify") +" #Over#");
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
