package com.jacky.spingbootmall.dao.impl;

import com.jacky.spingbootmall.dao.OrderDao;
import com.jacky.spingbootmall.dto.OrderQueryParams;
import com.jacky.spingbootmall.model.Order;
import com.jacky.spingbootmall.model.OrderItem;
import com.jacky.spingbootmall.model.Repository.OrderItemRepository;
import com.jacky.spingbootmall.model.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Integer countOrder(OrderQueryParams orderQueryParams) {
        // 使用內建的方法計算記錄數
        return orderRepository.countByUserId(orderQueryParams.getUserId()).intValue();
    }

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
        // 根據條件查詢訂單
        if (orderQueryParams.getUserId() != null) {
            return orderRepository.findByUserId(orderQueryParams.getUserId());
        }
        return orderRepository.findAllByOrderByCreatedDateDesc();
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElse(null);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Integer orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    @Override
    public Integer createOrder(Integer userId, Integer totalAmount) {
        Order newOrder = new Order();
        newOrder.setUserId(userId);
        newOrder.setTotalAmount(totalAmount);
        newOrder.setCreatedDate(new Date());
        newOrder.setLastModifiedDate(new Date());

        Order savedOrder = orderRepository.save(newOrder);
        return savedOrder.getOrderId();
    }

    @Override
    public void createOrderItems(Integer orderId, List<OrderItem> orderItemList) {
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderId(orderId);
        }
        orderItemRepository.saveAll(orderItemList);
    }
}
