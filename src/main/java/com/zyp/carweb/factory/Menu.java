package com.zyp.carweb.factory;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public abstract class Menu {
    public abstract List<JSONObject> produce();
}
