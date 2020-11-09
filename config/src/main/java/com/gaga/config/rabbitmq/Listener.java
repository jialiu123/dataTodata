package com.gaga.config.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {


    @RabbitListener(queues = "queue")
    public void listen1(String msg) {
        System.out.println("消费者接受到消息1：" + msg);
    }

    @RabbitListener(queues = "queue")
    public void listen2(String msg) {
        System.out.println("消费者接受到消息2：" + msg);
    }

    @RabbitListener(queues = "topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:" + str);
    }

    @RabbitListener(queues = "topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:" + str);
    }

    @RabbitListener(queues = "fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:" + str1);
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:" + str);
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:" + str);
    }
}