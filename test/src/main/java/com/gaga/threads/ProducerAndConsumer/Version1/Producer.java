package com.gaga.threads.ProducerAndConsumer.Version1;

import com.gaga.threads.ProducerAndConsumer.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingDeque;

/**
 * 模拟生产者
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 14:24
 * @version: 1.0
 */
@Slf4j(topic = "c.Producer")
public class Producer implements Runnable {

    private BlockingDeque<Message> queue;

    private volatile static boolean isStop = false;

    Producer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isStop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //扔进链表的最后面
            Message message = new Message("消息内容" + new Random().nextInt(10 - 1) + 1);
            queue.addLast(message);
            log.debug("生产消息：{}", message.toString());
        }
    }


    public void stop() {
        isStop = true;
    }


}
