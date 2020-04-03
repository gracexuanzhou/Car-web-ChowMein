package com.zyp.carweb.abstractFactory;

public class CustomerFactory implements MenuFactory {
    @Override
    public AbstractMenu getMenu() {
        return new CustomerMenu();
    }
}
