package com.jacky.spingbootmall.service.impl;

import com.jacky.spingbootmall.dao.UserDao;
import com.jacky.spingbootmall.dto.UserRegisterRequest;
import com.jacky.spingbootmall.model.User;
import com.jacky.spingbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
