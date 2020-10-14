package com.gaga.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch主要有两个方法，countDown()和await()方法，
 * 在创建CountDownLatch对象时候，初始值与调用countDown()次数相等后，
 * 调用await()方法的线程才会运行，这样就可以主线程在别的线程执行完了后，才结束。
 * <p>
 * 使用场景：可以分别创建新的线程单独处理一个子任务，当全部的子任务都处理完毕后，
 * 主线程进行汇总，各个分线程调用一次countDown()方法，主线程调用await()方法
 *
 * @author ：liujia
 * @date ：Created in 2020/9/9 15:32
 * @version: 1.0
 */
@Slf4j
public class CountDownLatchTest {


    public static void main(String[] args) throws Exception {
        testCountDownLatch();
    }

    public static void testCountDownLatch() throws Exception {

        final CountDownLatch end = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                log.info("开始执行：{}", finalI);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                end.countDown();

            }, "线程" + i).start();
        }

        end.await();
        log.info("Game Over.");
    }

    public static void testCountDownLatch2() throws Exception {

        final CountDownLatch mainLatch = new CountDownLatch(1);
        final CountDownLatch workerLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                log.info("开始工作：{}", finalI);
                workerLatch.countDown();
            }, "worker" + i).start();
        }

        new Thread(() -> {
            try {
                workerLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("监听工作结束");
            mainLatch.countDown();
        }, "listener").start();

        mainLatch.await();
        System.out.println("Game Over.");
    }
}
