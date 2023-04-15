package com.demo.sqs.services;

import com.demo.sqs.model.Order;

public interface OrderService {
    void processOrder(Order order);

    Order placeOrder(Order order);
}