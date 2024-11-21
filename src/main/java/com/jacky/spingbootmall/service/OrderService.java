package com.jacky.spingbootmall.service;

import com.jacky.spingbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
