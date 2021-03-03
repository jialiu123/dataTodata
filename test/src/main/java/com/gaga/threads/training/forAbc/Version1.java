package com.gaga.threads.training.forAbc;

import lombok.extern.slf4j.Slf4j;

/**
 * 3个线程依次数据 a b c
 * abcabcabc
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 22:31
 * @version: 1.0
 */
public class Version1 {

    public static void main(String[] args) {

        WaitNotify waitNotify = new WaitNotify(7);

        new Thread(() -> {
            waitNotify.print("a", 1, 2);
        }, "a").start();

        new Thread(() -> {
            waitNotify.print("b", 2, 3);
        }, "a").start();

        new Thread(() -> {
            waitNotify.print("c", 3, 1);
        }, "a").start();

    }

}

@Slf4j
class WaitNotify {


    private volatile int flag = 1;

    //循环次数
    private int loopNumber;

    WaitNotify(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String printContent, int thisFlag, int nextFlag) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (thisFlag != flag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(printContent);
                flag = nextFlag;
                this.notifyAll();
            }
        }

    }
}


