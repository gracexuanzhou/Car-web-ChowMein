package com.zyp.carweb.factory;

import com.alibaba.fastjson.JSONObject;
import com.zyp.carweb.model.User;

import java.time.LocalDate;

public class MerchantUser implements LoginLog {

    @Override
    public void loginLog(User userVo) {
        System.out.println("登录时间："+ LocalDate.now());
        System.out.println("登录身份：商家");
        System.out.println("登录信息："+ JSONObject.toJSONString(userVo));
    }
}
