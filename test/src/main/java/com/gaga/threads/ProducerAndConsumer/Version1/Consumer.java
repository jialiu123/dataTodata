package com.gaga.threads.ProducerAndConsumer.Version1;

import com.gaga.threads.ProducerAndConsumer.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingDeque;

/**
 * 消费者线程
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 14:47
 * @version: 1.0
 */
@Slf4j(topic = "c.Consumer")
public class Consumer implements Runnable {

    private BlockingDeque<Message> queue;

    private volatile static boolean isStop = false;

    Consumer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isStop) {
            if (!queue.isEmpty()) {
                Message message = queue.removeFirst();
                if (message != null) {
                    log.debug("消费消息：{}", message.toString());
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        isStop = true;
    }

}
