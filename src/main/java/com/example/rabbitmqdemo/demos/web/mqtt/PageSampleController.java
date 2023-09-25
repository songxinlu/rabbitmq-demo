package com.example.rabbitmqdemo.demos.web.mqtt;

import com.example.rabbitmqdemo.demos.config.mqtt.MqttConfig;
import com.example.rabbitmqdemo.demos.config.sender.ReadingSender;
import com.example.rabbitmqdemo.demos.config.mqtt.enums.QueueEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 即时通讯页面示例
 * @author: rengb
 * @time: 2021/1/5 18:27
 */
//@Api(tags = "mqtt推送")
@Controller
@RequestMapping("/pageSample")
public class PageSampleController {

    @Autowired
    private MqttConfig mqttConfig;

    @Autowired
    private ReadingSender readingSender;

    @GetMapping("/sample")
    public String index(ModelMap model) {
        model.addAttribute("mqtt_url", mqttConfig.getFrontUrl());
        return "sample";
    }

    @GetMapping("/send")
    @ResponseBody
    public String send() {
        readingSender.send(QueueEnum.QUEUE_OPER_TEST_RECORD.getExchange(),QueueEnum.QUEUE_OPER_TEST_RECORD.getRouteKey(),print());
        return "send";
    }


    public String print() {
        StringBuilder sb = new StringBuilder();
        //for循环打印一个图案
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}