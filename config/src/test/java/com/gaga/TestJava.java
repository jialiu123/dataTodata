package com.gaga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：liujia
 * @date ：Created in 2020/9/26 15:02
 * @version: 1.0
 */
@Slf4j
public class TestJava {

    private static ThreadPoolExecutor executorProducterService = ExcutorFactory.getProducterInstance(4);
    private static ThreadPoolExecutor executorConsumerService = ExcutorFactory.getConsumerInstance(6);


    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            executorProducterService.submit(new Producter());
        }

        for (int i = 0; i < 5; i++) {
            executorConsumerService.submit(new Consumer());
        }

    }

    //线程安全的 不需要加锁
    private static LinkedBlockingDeque<Person> deque = new LinkedBlockingDeque<>(5);

    private static final int capacity = 5;

    static class Producter extends Thread {

        @Override
        public void run() {
            while (true) {
                if (deque.size() < capacity) {
                    Person tempPerson = new Person("123", new Random().nextInt(30 - 0) + 0);
                    try {
                        deque.put(tempPerson);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    log.info("开始生产啦:{}", tempPerson);
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                if (!deque.isEmpty()) {
                    Person tempPerson = deque.remove();
                    log.info("开始消费啦:{}", tempPerson);
                }
            }
        }
    }


    @Data
    @AllArgsConstructor
    static class Person {

        private String name;

        private int age;

    }


}

