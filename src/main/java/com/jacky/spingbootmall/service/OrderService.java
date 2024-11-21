package com.jacky.spingbootmall.service;

import com.jacky.spingbootmall.dto.CreateOrderRequest;
import com.jacky.spingbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
