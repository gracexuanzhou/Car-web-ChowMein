package com.zyp.carweb.service;

import com.zyp.carweb.model.User;

public interface UserService {

    public User findByUser(User user);

    int insertSelective(User user);
}
