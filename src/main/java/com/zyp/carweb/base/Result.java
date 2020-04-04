package com.zyp.carweb.base;

import java.io.Serializable;
import java.util.HashMap;

public class Result<T> extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public static Result error() {
        return error(1, "操作失败");
    }

    public static Result error(String msg) {
        return error(1, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Object obj) {
        Result r = new Result();
        r.put("data", obj);
        //r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result<T> put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
