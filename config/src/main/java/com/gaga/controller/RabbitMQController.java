package com.gaga.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Direct模式相当于一对一模式,一个消息被发送者发送后,会被转发到一个绑定的消息队列中,然后被一个接收者接收!
 */
@RequestMapping("/rabbit")
@Controller
@Slf4j
public class RabbitMQController {

    @Autowired
    private AmqpTemplate template;

    @GetMapping(value = "/sendDirect")
    @ResponseBody
    public void sendMsg() {

        for (int i = 0; i < 100; i++) {
            template.convertAndSend("queue", "hello,rabbit~" + i);
        }

    }

    @GetMapping(value = "/sendTopic")
    @ResponseBody
    public void sendMsgTopic() {

        for (int i = 0; i < 100; i++) {
            template.convertAndSend("exchange", "topic.message", "hello,rabbit~~~11" + i);
            template.convertAndSend("exchange", "topic.messages", "hello,rabbit~~~22" + i);
        }

    }

    @GetMapping(value = "/sendFanout")
    @ResponseBody
    public void sendMsgFanout() {

        for (int i = 0; i < 100; i++) {
            template.convertAndSend("fanoutExchange", "", "hello,rabbit~~~11" + i);
        }

    }


}