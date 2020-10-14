package com.gaga.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
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
