package com.example.rabbitmqdemo.demos.config.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: rabbitmq-demo
 * @Author: sxl
 * @Description: 发送消息
 * @Date: 2023/9/6 16:35
 * @Version: 1.0
 */
@Component
public class ReadingSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String exchange,String routeKey,Object t) {
        rabbitTemplate.convertAndSend(exchange,routeKey, t);
    }
}
