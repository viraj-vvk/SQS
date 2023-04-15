package com.demo.sqs.services.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.demo.sqs.model.Order;
import com.demo.sqs.services.OrderService;
import com.demo.sqs.producer.SqsMessageProdeucer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private SqsMessageProdeucer prducer;

    @Override
    public void processOrder(Order order) {
        log.debug("order processed");
    }

    @Override
    public Order placeOrder(Order order) {
        order.setOrderId(UUID.randomUUID());
        order.setOrderDate(LocalDate.now());

        Map<String, Object> headers = new HashMap<String, Object>() {
            {
                put("Message-Type", "Order");
                put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            }
        };
        prducer.send(order, headers);
        return order;
    }

}