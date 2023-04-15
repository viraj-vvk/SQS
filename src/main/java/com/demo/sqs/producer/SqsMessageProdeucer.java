package com.demo.sqs.producer;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SqsMessageProdeucer {
    @Value("${orders.queue.name}")
    private String queueName;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public <T> void send(T message, Map<String, Object> headers) {
        if (Objects.isNull(message)) {
            log.warn("SQS Producer can't produce null value");
        }
        log.debug("Message: {}", message);
        log.debug("queue name: {}", queueName);
        queueMessagingTemplate.convertAndSend(queueName, message, headers);
    }
}
