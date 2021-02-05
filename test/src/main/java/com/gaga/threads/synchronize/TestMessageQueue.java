package com.gaga.threads.synchronize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：liujia
 * @date ：Created in 2021/2/4 21:10
 * @description：模拟生产者和消费者
 * @version: 1.0
 */
@Slf4j
public class TestMessageQueue {


    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    messageQueue.put2(new Message(finalI, "消息" + finalI));
                }
            }, "生产者线程" + i).start();
        }

        new Thread(() -> {
            while (true) {
                Message message = messageQueue.take2();
                if (message != null) {
                    log.debug(message.toString());
                }
            }
        }, "消费者线程").start();

    }

}


@Slf4j
final class MessageQueue {

    //数据结构 是不安全的
    private LinkedList<Message> list1 = new LinkedList<>();

    //是安全的
    private ConcurrentLinkedDeque<Message> list2 = new ConcurrentLinkedDeque();

    private ReentrantLock lock = new ReentrantLock();

    // 队列最大数
    private int capcity;

    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    public Message take2() {

        lock.lock();
        try {
            if (list2.isEmpty()) {
//                log.debug("队列为空，不能进行消费");
            } else {
                Message message = list2.removeFirst();
                log.debug("开始消费");
                return message;
            }
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void put2(Message message) {

        lock.lock();
        try {
            if (list2.size() == capcity) {
                //证明满了，不能再放了
//                log.debug("生产者已经满了，不能在进行生产了");
            } else {
                log.debug("开始生产");
                Thread.sleep(1000);
                list2.addFirst(message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public Message take() {
        synchronized (list1) {
            while (list1.isEmpty()) {
                try {
                    log.debug("队列为空，不能进行消费");
                    list1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list1.removeFirst();
            log.debug("开始消费");
            list1.notifyAll();
            return message;
        }
    }

    public void put(Message message) {
        synchronized (list1) {
            while (list1.size() == capcity) {
                //证明满了，不能再放了
                try {
                    log.debug("生产者已经满了，不能在进行生产了");
                    list1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("开始生产");
            list1.addFirst(message);
            list1.notifyAll();
        }
    }

}

@Getter
@AllArgsConstructor
@ToString
class Message {
    private int id;
    private Object value;
}





