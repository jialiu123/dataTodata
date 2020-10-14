package com.gaga.threads;

import java.util.concurrent.Semaphore;

/**
 * Semphere可控制运行中线程的数目，通过acquire()方法进入，release()方法退出
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " start");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " end");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
