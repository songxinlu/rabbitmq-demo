package com.example.rabbitmqdemo.demos.config.mqtt.component;

import com.example.rabbitmqdemo.demos.config.mqtt.enums.QueueEnum;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息的发出者
 * @author: rengb
 * @time: 2021/1/5 18:27
 */

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

/**
     * 基础信息变更导致redis需要刷新—消息发送
     */

    public void sendRedisCacheRefreshMessage(String type) {
        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_REDIS_CACHE_REFRESH.getExchange(), QueueEnum.QUEUE_REDIS_CACHE_REFRESH.getRouteKey(), type, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {

//                queue的持久化是通过durable=true来实现的。
//                deliveryMode=2代表持久化
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        });
    }

/**
     * 用户登录成功后记录日志
     *//*

    public void sendLogSuccessRecordMessage(LoginLogDTO loginLog) {
        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_LOGIN_SUCESS_RECORD.getExchange(), QueueEnum.QUEUE_LOGIN_SUCESS_RECORD.getRouteKey(), loginLog, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        });
    }

    */
/**
     * 用户操作后记录日志
     *//*

    public void sendOperLogRecordMessage(OperationLogDTO operationLog) {
        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_OPER_LOG_RECORD.getExchange(), QueueEnum.QUEUE_OPER_LOG_RECORD.getRouteKey(), operationLog, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        });
    }

    */
/**
     * 用户操作异常记录日志
     *//*

    public void operErrorLogRecordMessage(AbnormalLogDTO abnormalLogDTO) {
        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_OPER_ERROR_RECORD.getExchange(), QueueEnum.QUEUE_OPER_ERROR_RECORD.getRouteKey(), abnormalLogDTO, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        });
    }*/
}
