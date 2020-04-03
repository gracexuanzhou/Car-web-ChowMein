package com.zyp.carweb.abstractFactory;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public abstract class AbstractMenu {
    public abstract List<JSONObject> produce();
}
