package com.gaga.threads.ProducerAndConsumer.Version1;

import com.gaga.threads.ProducerAndConsumer.Message;

import java.util.concurrent.*;

/**
 * @author ：liujia
 * @date ：Created in 2021/2/5 14:40
 * @version: 1.0
 */
public class TestVersion1 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        BlockingDeque<Message> queue = new LinkedBlockingDeque();
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);

        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);

        Consumer consumer = new Consumer(queue);
        executorService.execute(consumer);

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumer.stop();
        p1.stop();
        p2.stop();
        p3.stop();
        executorService.shutdown();

    }
}
