package com.zyp.carweb.abstractFactory;

public class MerchantFactory implements MenuFactory {
    @Override
    public AbstractMenu getMenu() {
        return new MerchantMenu();
    }
}
