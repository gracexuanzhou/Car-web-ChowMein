package com.zyp.carweb.interceptor.interceptors;

import com.zyp.carweb.interceptor.framework.Context;

public interface Interceptor {
    public void execute(Context ctx);
}
