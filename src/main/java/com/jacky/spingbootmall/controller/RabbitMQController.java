package com.jacky.spingbootmall.controller;

import com.jacky.spingbootmall.service.RabbitMQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQController.class);

    @Autowired
    private RabbitMQService rabbitMQService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestHeader("Tenant-ID") String tenantId, @RequestBody String message) {
        if (tenantId == null || tenantId.isEmpty() || message == null || message.isEmpty()) {
            logger.warn("Invalid request body or missing Tenant-ID header");
            return "Invalid request body or missing Tenant-ID header";
        }
        rabbitMQService.sendMessage(message);
        logger.info("Message sent to RabbitMQ: {}", message);
        return "Message sent: " + message;
    }

    @GetMapping("/queue/status")
    public String getQueueStatus() {
        int messageCount = rabbitTemplate.execute(channel -> channel.queueDeclarePassive("debug_queue").getMessageCount());
        logger.info("Messages in queue: {}", messageCount);
        return "Messages in queue: " + messageCount;
    }
}