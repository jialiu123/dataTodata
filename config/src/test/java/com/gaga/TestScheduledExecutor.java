package com.gaga;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ：liujia
 * @date ：Created in 2020/9/26 20:28
 * @version: 1.0
 */
@Slf4j
public class TestScheduledExecutor {

    public static void main(String[] args) {
        ScheduledExecutorService time = Executors.newScheduledThreadPool(3);


        //就是不管执行多长时间，都是间隔3s
        time.scheduleAtFixedRate(() -> {
            log.info("=============");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 2, TimeUnit.SECONDS);

        //就是不管执行多长时间，都是间隔3s
//        ScheduledFuture<?> scheduledFuture = time.scheduleWithFixedDelay(() -> {
//            log.info("=============");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 1, 2, TimeUnit.SECONDS);


    }

}
