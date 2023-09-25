package com.example.rabbitmqdemo.demos.config.mqtt;

import com.example.rabbitmqdemo.demos.config.mqtt.enums.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 消息队列相关配置
 * @author: rengb
 * @time: 2021/1/5 18:27
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 基础信息变更导致redis需要刷新—队列所绑定的交换机
     */
    @Bean
    DirectExchange redisCacheRefreshDirect() {
        return ExchangeBuilder.directExchange(QueueEnum.QUEUE_REDIS_CACHE_REFRESH.getExchange()).durable(true).build();
    }

    /**
     * 基础信息变更导致redis需要刷新—队列
     */
    @Bean
    public Queue redisCacheRefreshQueue() {
        return new Queue(QueueEnum.QUEUE_REDIS_CACHE_REFRESH.getName(), true, false, false);
    }


    /**
     * 将-基础信息变更导致redis需要刷新-队列绑定到交换机
     */
    @Bean
    Binding redisCacheRefreshBinding(DirectExchange redisCacheRefreshDirect, Queue redisCacheRefreshQueue) {
        return BindingBuilder
                .bind(redisCacheRefreshQueue)
                .to(redisCacheRefreshDirect)
                .with(QueueEnum.QUEUE_REDIS_CACHE_REFRESH.getRouteKey());
    }

    /**
     * 用户登录成功后记录日志需要刷新—队列所绑定的交换机
     */
    @Bean
    DirectExchange loginSuccessRecordDirect() {
        return ExchangeBuilder.directExchange(QueueEnum.QUEUE_LOGIN_SUCESS_RECORD.getExchange()).durable(true).build();
    }

    /**
     * 用户登录成功后记录日志需要刷新—队列
     */
    @Bean
    public Queue loginSuccessRecordQueue() {
        return new Queue(QueueEnum.QUEUE_LOGIN_SUCESS_RECORD.getName(), true, false, false);
    }


    /**
     * 用户登录成功后记录日志需要刷新-队列绑定到交换机
     */
    @Bean
    Binding loginSuccessRecordBinding(DirectExchange loginSuccessRecordDirect, Queue loginSuccessRecordQueue) {
        return BindingBuilder
                .bind(loginSuccessRecordQueue)
                .to(loginSuccessRecordDirect)
                .with(QueueEnum.QUEUE_LOGIN_SUCESS_RECORD.getRouteKey());
    }

    /**
     * 用户操作后记录日志需要刷新—队列所绑定的交换机
     */
    @Bean
    DirectExchange operLogRecordDirect() {
        return ExchangeBuilder.directExchange(QueueEnum.QUEUE_OPER_LOG_RECORD.getExchange()).durable(true).build();
    }

    /**
     * 用户操作后记录日志需要刷新—队列
     */
    @Bean
    public Queue operLogRecordQueue() {
        return new Queue(QueueEnum.QUEUE_OPER_LOG_RECORD.getName(), true, false, false);
    }

    /**
     * 用户操作后记录日志需要刷新-队列绑定到交换机
     */
    @Bean
    Binding operLogRecordBinding(DirectExchange operLogRecordDirect, Queue operLogRecordQueue) {
        return BindingBuilder
                .bind(operLogRecordQueue)
                .to(operLogRecordDirect)
                .with(QueueEnum.QUEUE_OPER_LOG_RECORD.getRouteKey());
    }

    /**
     * 用户操作异常记录日志需要刷新—队列所绑定的交换机
     */
    @Bean
    DirectExchange operErrorRecordDirect() {
        return ExchangeBuilder.directExchange(QueueEnum.QUEUE_OPER_ERROR_RECORD.getExchange()).durable(true).build();
    }

    /**
     * 用户操作异常记录日志需要刷新—队列
     */
    @Bean
    public Queue operErrorRecordQueue() {
        return new Queue(QueueEnum.QUEUE_OPER_ERROR_RECORD.getName(), true, false, false);
    }

    /**
     * 用户操作异常记录日志需要刷新-队列绑定到交换机
     */
    @Bean
    Binding operErrorRecordBinding(DirectExchange operErrorRecordDirect, Queue operErrorRecordQueue) {
        return BindingBuilder
                .bind(operErrorRecordQueue)
                .to(operErrorRecordDirect)
                .with(QueueEnum.QUEUE_OPER_ERROR_RECORD.getRouteKey());
    }



    /**
     * 测试队列绑定的交换机
     */
    @Bean
    DirectExchange testDirect() {
        return ExchangeBuilder.directExchange(QueueEnum.QUEUE_OPER_TEST_RECORD.getExchange()).durable(true).build();
    }

    /**
     * 测试刷新—队列
     */
    @Bean
    public Queue testQueue() {
        return new Queue(QueueEnum.QUEUE_OPER_TEST_RECORD.getName(), true, false, false);
    }


    /**
     * 测试队列绑定到交换机
     */
    @Bean
    Binding testBinding(DirectExchange testDirect, Queue testQueue) {
        return BindingBuilder
                .bind(testQueue)
                .to(testDirect)
                .with(QueueEnum.QUEUE_OPER_TEST_RECORD.getRouteKey());
    }
}