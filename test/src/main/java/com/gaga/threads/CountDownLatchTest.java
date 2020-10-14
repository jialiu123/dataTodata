package com.gaga.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
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
            }, "现场" + i).start();
        }

        end.await();
        System.out.println("Game Over.");
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
