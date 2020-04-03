package com.zyp.carweb.interceptor.framework.Service;


import com.zyp.carweb.interceptor.framework.Context;


public interface Service { //这里都是定义的Interceptor concrete framwork 具体框架的服务：
                             // e.g. 当用户浏览网页，发送HTTP 请求， 服务器可以看做我们的ConcreteFramwork, 这个时候
                             // Service可以看做REST API调用 ---》 业务逻辑的调用
                             // 带外服务可以是，监测这个HTTP请求是否包含敏感信息。XSS注入之类都。
    public void execute(Context ctxObj_msg) ; //ctxObj_msg = ctxObj
}
