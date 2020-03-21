package com.zyp.carweb.factory;

public class LoginLogFactory {

    public LoginLog getLoginLog(String type){
        LoginLog loginLog = null;
        switch (type){
            case "merchant":
                loginLog = new MerchantUser();
                break;
            case "customer":
                loginLog = new CustomerUser();
                break;
        }
        return loginLog;
    }
}
