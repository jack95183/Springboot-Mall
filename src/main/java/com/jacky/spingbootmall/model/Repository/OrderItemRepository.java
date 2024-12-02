package com.jacky.spingbootmall.model.Repository;

import com.jacky.spingbootmall.model.OrderItem;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

    List<OrderItem> findByOrderId(Integer orderId);

}