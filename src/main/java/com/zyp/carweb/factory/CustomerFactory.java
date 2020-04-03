package com.zyp.carweb.factory;

public class CustomerFactory implements MenuFactory {
    @Override
    public Menu getMenu() {
        return new CustomerMenu();
    }
}
