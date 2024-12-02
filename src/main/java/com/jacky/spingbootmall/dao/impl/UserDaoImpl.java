package com.jacky.spingbootmall.dao.impl;

import com.jacky.spingbootmall.dao.UserDao;
import com.jacky.spingbootmall.dto.UserRegisterRequest;
import com.jacky.spingbootmall.model.User;
import com.jacky.spingbootmall.model.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());
        user.setCreatedDate(new java.util.Date());
        user.setLastModifiedDate(new java.util.Date());

        User savedUser = userRepository.save(user);
        return savedUser.getUserId();
    }
}
