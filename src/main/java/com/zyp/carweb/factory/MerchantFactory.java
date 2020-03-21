package com.zyp.carweb.factory;

public class MerchantFactory implements MenuFactory {
    @Override
    public Menu getMenu() {
        return new MerchantMenu();
    }
}
