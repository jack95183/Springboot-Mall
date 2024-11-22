package com.jacky.spingbootmall.service;

import com.jacky.spingbootmall.dto.CreateOrderRequest;
import com.jacky.spingbootmall.dto.OrderQueryParams;
import com.jacky.spingbootmall.model.Order;

import java.util.List;

public interface OrderService {
    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
