package com.gaga.threads;

/**
 * @author ：liujia
 * @date ：Created in 2021/2/7 10:47
 * @version: 1.0
 */
public class Test1 {

    static int x;

    private static volatile boolean hasEdit = false;

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();


        new Thread(() -> {
            synchronized (lock) {
                while (hasEdit) {
                    x = 2;
                    break;
                }
            }
        }, "t1").start();


        new Thread(() -> {
            x = 4;
            hasEdit = true;

        }, "t2").start();

        Thread.sleep(500);

        System.out.println(x);

    }

}
