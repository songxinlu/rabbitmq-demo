package com.example.rabbitmqdemo.demos.config.mqtt.component;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息的处理者
 * @author: rengb
 * @time: 2021/1/5 18:27
 */

@Slf4j
@Component
public class MessageReceiver {


    // ack 方式(noack, auto, manual)
    // MANUAL: 手动确认
    @RabbitListener(queues = "emrais.redis.cache.refresh.queue", ackMode = "MANUAL")
    public void RedisCacheRefreshHandle(String data, Message message, Channel channel) throws Exception {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    /*@RabbitListener(queues = "emrais.login.success.record.queue", ackMode = "MANUAL")
    public void sendLogSuccessMessageHandle(LoginLogDTO loginLog, Message message, Channel channel) throws Exception {
        loginLog.setLoginAddress(AddressUtils.getRealAddressByIP(loginLog.getLoginIp()));
        securityService.addLoginLog(loginLog);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = "emrais.oper.log.record.queue", ackMode = "MANUAL")
    public void sendOperLogRecordMessage(OperationLogDTO operationLog, Message message, Channel channel) throws Exception {
        operationLog.setOperationAddress(AddressUtils.getRealAddressByIP(operationLog.getOperationIp()));
        securityService.addOperLog(operationLog);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(queues = "emrais.oper.error.record.queue", ackMode = "MANUAL")
    public void sendOperErrorRecordMessage(AbnormalLogDTO abnormalLogDTO, Message message, Channel channel) throws Exception {
        securityService.addOperErrorLog(abnormalLogDTO);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }*/

}
