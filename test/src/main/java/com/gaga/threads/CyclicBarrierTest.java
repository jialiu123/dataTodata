package com.gaga.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier主要有await()和reset()方法，
 * 当调用await()方法的线程数目与CyclicBarrier初始线程值相同时，
 * 所有线程才可进行下面程序，reset()方法，可以修改构造函数中的初始值，CountDownLatch不能重置。
 *
 * @author ：liujia
 * @date ：Created in 2020/10/14 11:02
 * @version: 1.0
 */
@Slf4j
public class CyclicBarrierTest {

    public static void main(String[] args) throws Exception {
        testCountDownLatch();
    }

    public static void testCountDownLatch() throws Exception {

        final CyclicBarrier end = new CyclicBarrier(10, new Thread(() -> {
            log.info("执行结束啦");
        }));

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                log.info("开始执行：{}", finalI);
                try {
                    end.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "现场" + i).start();
        }
    }

}
