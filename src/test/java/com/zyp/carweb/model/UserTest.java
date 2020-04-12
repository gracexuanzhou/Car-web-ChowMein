package com.zyp.carweb.model;

import org.junit.Test;

public class UserTest {

    private String username;
    private String password;
    private String loginname;
    private int id;
    private int usertype;

    @Test
    public void testUser(){
        User us = new User();
        us.setId(100);
        us.setUserName("chaomian");
        us.setLoginName("chaomian");
        us.setPassWord("chaomian");
        us.setUserType(1);
        User us1 = new User(us.getId(),us.getUserName(),us.getLoginName(),us.getPassWord(),us.getUserType());
        System.out.println("user id:" + us1.getId());
        System.out.println("user name:" + us1.getUserName());


    }


}