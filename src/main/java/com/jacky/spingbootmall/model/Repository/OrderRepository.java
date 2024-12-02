package com.jacky.spingbootmall.model.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jacky.spingbootmall.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findByUserId(Integer userId);

    Long countByUserId(Integer userId);

    List<Order> findAllByOrderByCreatedDateDesc();
}