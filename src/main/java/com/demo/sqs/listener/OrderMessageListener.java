package com.demo.sqs.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import com.demo.sqs.model.Order;
import com.demo.sqs.services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderMessageListener {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private OrderService orderService;

    @SqsListener(value = "${orders.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void prodeuceMessage(String message) {
        log.debug("Recieved new SQS message: {}", message);
        try {
            Order order = OBJECT_MAPPER.readValue(message, Order.class);
            orderService.processOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Cannot process message from SQS, %s", e));
        }
    }
}
