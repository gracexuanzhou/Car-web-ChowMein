package com.zyp.carweb.abstractFactory;

public class AbstractFactoryProducter {
    public static MenuFactory getFactory(Integer type){
        if(type == 1){
            return new CustomerFactory();
        } else if(type == 2){
            return new MerchantFactory();
        }
        return null;
    }
}
