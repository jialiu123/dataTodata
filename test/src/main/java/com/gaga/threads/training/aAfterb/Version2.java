package com.gaga.threads.training.aAfterb;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现先输出a 在输出b  ReentrantLock版本的实现
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 22:18
 * @version: 1.0
 */
@Slf4j
public class Version2 {


    private static volatile boolean hasPrintA = false;

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {


        new Thread(() -> {

            lock.lock();
            try {
                while (!hasPrintA) {
                    condition.await();
                }
                log.debug("b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "b").start();


        new Thread(() -> {
            lock.lock();
            try {
                log.debug("a");
                hasPrintA = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }, "a").

                start();
    }
}


