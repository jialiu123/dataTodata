package com.gaga.threads.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：liujia
 * @date ：Created in 2021/3/2 10:55
 * @version: 1.0
 */
@Slf4j
public class ThreadPoolTest {


    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 10000, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(1000));

        for (int i = 0; i < 3000; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> {
                log.info("线程,{}" + finalI);
            });
        }

//        threadPoolExecutor.shutdown();


    }


}
