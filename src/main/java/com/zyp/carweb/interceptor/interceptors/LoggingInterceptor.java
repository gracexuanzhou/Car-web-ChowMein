package com.zyp.carweb.interceptor.interceptors;


import com.zyp.carweb.interceptor.framework.Context;


public class LoggingInterceptor implements Interceptor {
    @Override
    public void execute(Context ctx) {
        System.out.println("操作人："+ctx.getCreator());
        System.out.println("修改后信息："+ctx.getMsg());
    }
}
