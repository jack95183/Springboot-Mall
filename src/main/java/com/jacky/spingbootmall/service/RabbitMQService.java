package com.jacky.spingbootmall.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RabbitMQService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        logger.info("Sending message: {}", message);
        rabbitTemplate.convertAndSend("amq.topic", "test.*", message);
        logger.info("Message sent: {}", message);
    }

    @RabbitListener(queues = "debug_queue")
    public void handleMessage(String message) {
        logger.info("Received message: {}", message);
        // 在这里处理消息
    }
}