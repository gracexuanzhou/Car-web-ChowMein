package com.zyp.carweb.service.impl;

import com.zyp.carweb.dao.UserMapper;
import com.zyp.carweb.model.User;
import com.zyp.carweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUser(User user) {
        return userMapper.selectByParam(user);
    }
    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

}
