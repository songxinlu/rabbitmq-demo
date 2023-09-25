package com.example.rabbitmqdemo.demos.config.receiver;

import com.example.rabbitmqdemo.demos.config.mqtt.gateway.MqttGateway;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadingReceiver {
	@Autowired
	private MqttGateway mqttGateway;

	@RabbitHandler
	@RabbitListener(queues = "mqtt.test.record.queue")
	public void process(String receiveMessage) {
		mqttGateway.sendToMqtt(receiveMessage,"1");
		System.out.println(receiveMessage);
	}
}