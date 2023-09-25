package com.example.rabbitmqdemo.demos.web.mqtt;

import com.example.rabbitmqdemo.demos.config.mqtt.gateway.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 即时通讯后端示例
 * @author: rengb
 * @time: 2021/1/5 18:27
 */
@RestController
//@Api(value = "即时通讯后端示例", tags = { "即时通讯后端示例" })
@RequestMapping("/backSample")
public class BackSampleController {

    @Autowired
    private MqttGateway mqttGateway;

//    @PostMapping("/sendToDefaultTopic")
//    @ApiOperation("向默认主题发送消息")
//    public ResponseData sendToDefaultTopic(String payload) {
//        mqttGateway.sendToMqtt(payload);
//        return ResponseData.SUCCESS(null);
//    }
//
//    @PostMapping("/sendToTopic")
//    @ApiOperation("向指定主题发送消息")
//    public ResponseData sendToTopic(@RequestBody List<ZkzyPublishDTO> sendToTopics) {
//        if(CollectionUtil.isNotEmpty(sendToTopics)){
//            sendToTopics.stream().forEach(sendToTopicDTO -> {
//                mqttGateway.sendToMqtt(JSONObject.toJSONString(sendToTopicDTO), sendToTopicDTO.getDeviceId()+"");
//            });
//        }
//        return ResponseData.SUCCESS(null);
//    }

}