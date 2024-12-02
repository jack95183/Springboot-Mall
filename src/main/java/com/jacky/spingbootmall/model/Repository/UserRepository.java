package com.jacky.spingbootmall.model.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jacky.spingbootmall.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}