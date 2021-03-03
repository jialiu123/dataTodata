package com.gaga.threads.training.forAbc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程依次数据 a b c
 * abcabcabc
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 22:31
 * @version: 1.0
 */
public class Version2 {

    public static void main(String[] args) throws InterruptedException {

        LockUnLock lockUnLock = new LockUnLock(7);

        Condition conditionA = lockUnLock.newCondition();
        Condition conditionB = lockUnLock.newCondition();
        Condition conditionC = lockUnLock.newCondition();

        new Thread(() -> {
            lockUnLock.print("a", conditionA, conditionB);
        }, "a").start();

        new Thread(() -> {
            lockUnLock.print("b", conditionB, conditionC);
        }, "a").start();

        new Thread(() -> {
            lockUnLock.print("c", conditionC, conditionA);
        }, "a").start();

        TimeUnit.SECONDS.sleep(1);


        lockUnLock.lock();
        try {
            System.out.println("主线程发起第一次唤醒操作。。。。");
            conditionA.signal();
        } finally {
            lockUnLock.unlock();
        }


    }

}

@Slf4j
class LockUnLock extends ReentrantLock {

    //循环次数
    private int loopNumber;

    LockUnLock(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String printContent, Condition currCondition, Condition nextCondition) {
        for (int i = 0; i < loopNumber; i++) {
            this.lock();
            try {
                currCondition.await();
                System.out.print(printContent);
                nextCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }

        }

    }
}


