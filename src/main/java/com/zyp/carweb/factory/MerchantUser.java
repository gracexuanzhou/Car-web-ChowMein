package com.zyp.carweb.factory;

import com.alibaba.fastjson.JSONObject;
import com.zyp.carweb.model.User;

import java.time.LocalDate;

public class MerchantUser implements LoginLog {

    @Override
    public void loginLog(User userVo) {
        System.out.println("Login time："+ LocalDate.now());
        System.out.println("Login identity: merchant");
        System.out.println("login information："+ JSONObject.toJSONString(userVo));
    }
}
