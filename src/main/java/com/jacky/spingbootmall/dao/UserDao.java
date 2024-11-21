package com.jacky.spingbootmall.dao;

import com.jacky.spingbootmall.dto.UserRegisterRequest;
import com.jacky.spingbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);
    User getUserByEmail(String eamil);
    Integer createUser(UserRegisterRequest userRegisterRequest);
}
