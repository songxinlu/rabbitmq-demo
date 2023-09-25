package com.example.rabbitmqdemo.demos.config.mqtt;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: MQTT相关配置
 * @author: rengb
 * @time: 2021/1/5 18:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Component
@ConfigurationProperties(prefix = "rabbitmq.mqtt")
public class MqttConfig {

    /**
     * RabbitMQ的MQTT默认topic
     */
    private String defaultTopic;

    /**
     * RabbitMQ的MQTT连接地址
     */
    private String url;

    /**
     * RabbitMQ的MQTT前端页面连接地址
     */
    private String frontUrl;

}