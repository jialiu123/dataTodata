package com.gaga.threads.training.aAfterb;

import lombok.extern.slf4j.Slf4j;

/**
 * 实现先输出a 在输出b synchronized实现
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 22:18
 * @version: 1.0
 */
@Slf4j
public class Version1 {


    private static final Object lock = new Object();

    private static volatile boolean hasPrintA = false;

    public static void main(String[] args) {


        new Thread(() -> {
            synchronized (lock) {
                while (!hasPrintA) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                log.debug("b");

            }
        }, "b").start();


        new Thread(() -> {
            synchronized (lock) {
                log.debug("a");
                hasPrintA = true;
                lock.notifyAll();
            }
        }, "a").start();
    }
}


