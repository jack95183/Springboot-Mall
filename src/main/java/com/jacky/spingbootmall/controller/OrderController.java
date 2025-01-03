package com.jacky.spingbootmall.controller;

import com.jacky.spingbootmall.dto.CreateOrderRequest;
import com.jacky.spingbootmall.dto.OrderQueryParams;
import com.jacky.spingbootmall.model.Order;
import com.jacky.spingbootmall.model.OrderItem;
import com.jacky.spingbootmall.service.OrderService;
import com.jacky.spingbootmall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getOrders(@PathVariable Integer userId,
                                                 @RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit,
                                                 @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ) {
        OrderQueryParams orderQueryParams = new OrderQueryParams();
        orderQueryParams.setUserId(userId);
        orderQueryParams.setLimit(limit);
        orderQueryParams.setOffset(offset);

        //取得order list
        List<Order> orderList = orderService.getOrders(orderQueryParams);

        //取得order 總數
        Integer count = orderService.countOrder(orderQueryParams);

        //分頁
        Page<Order> page = new Page<>();
        page.setTotal(count);
        page.setLimit(limit);
        page.setOffset(offset);
        page.setResults(orderList);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest) {

        Integer orderId = orderService.createOrder(userId, createOrderRequest);

        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
