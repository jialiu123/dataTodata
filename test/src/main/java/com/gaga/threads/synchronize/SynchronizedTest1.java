package com.gaga.threads.synchronize;

import org.junit.Test;

/**
 * 锁对象
 *
 * @author ：liujia
 * @date ：Created in 2021/1/27 16:33
 * @version: 1.0
 */
public class SynchronizedTest1 {


    private synchronized void lockObj1() throws Exception {
        System.out.println(1111);
        Thread.sleep(2000);
    }

    private void lockObj2() throws Exception {
        synchronized (this) {
            System.out.println(1111);
            Thread.sleep(2000);
        }
    }

    private static synchronized void lockClass1() throws Exception {
        System.out.println(1111);
        Thread.sleep(2000);
    }

    private void lockClass2() throws Exception {
        synchronized (SynchronizedTest1.class) {
            System.out.println(1111);
            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) {
//        testLockObj();
//        testLockObj2();
//        testLockClass1();
        testLockClass2();
    }

    /**
     * 锁对象的 不同对象调用不会锁
     */
    public static void testLockObj() {
        SynchronizedTest1 synchronizedTest1 = new SynchronizedTest1();
        SynchronizedTest1 synchronizedTest2 = new SynchronizedTest1();

        new Thread(() -> {
            try {
                synchronizedTest1.lockObj1();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "111").start();

        new Thread(() -> {
            try {
                synchronizedTest2.lockObj1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "222").start();

    }

    @Test
    public static void testLockObj2() {
        SynchronizedTest1 synchronizedTest1 = new SynchronizedTest1();
        SynchronizedTest1 synchronizedTest2 = new SynchronizedTest1();

        new Thread(() -> {
            try {
                synchronizedTest1.lockObj2();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "111").start();

        new Thread(() -> {
            try {
                synchronizedTest2.lockObj2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "222").start();
    }


    @Test
    public static void testLockClass1() {

        new Thread(() -> {
            try {
                lockClass1();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "111").start();

        new Thread(() -> {
            try {
                lockClass1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "222").start();
    }


    @Test
    public static void testLockClass2() {

        SynchronizedTest1 synchronizedTest1 = new SynchronizedTest1();
        SynchronizedTest1 synchronizedTest2 = new SynchronizedTest1();

        new Thread(() -> {
            try {
                synchronizedTest1.lockClass2();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "111").start();

        new Thread(() -> {
            try {
                synchronizedTest2.lockClass2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "222").start();
    }


}
