package com.gaga.threads.training.forAbc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 3个线程依次数据 a b c
 * abcabcabc
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 22:31
 * @version: 1.0
 */
public class Version3 {

    private static Thread a;
    private static Thread b;
    private static Thread c;

    public static void main(String[] args) throws InterruptedException {


        ParkUnPark parkUnPark = new ParkUnPark(7);
        a = new Thread(() -> {
            parkUnPark.print("a", b);
        }, "a");

        b = new Thread(() -> {
            parkUnPark.print("b", c);
        }, "b");

        c = new Thread(() -> {
            parkUnPark.print("c", a);
        }, "c");

        a.start();
        b.start();
        c.start();

        TimeUnit.SECONDS.sleep(1);

        LockSupport.unpark(a);

    }

}

class ParkUnPark {

    //循环次数
    private int loopNumber;

    ParkUnPark(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String printContent, Thread nexThread) {
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(printContent);
            LockSupport.unpark(nexThread);
        }

    }
}


