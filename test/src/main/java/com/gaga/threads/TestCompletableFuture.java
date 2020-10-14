package com.gaga.threads;

import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author ：liujia
 * @date ：Created in 2020/9/29 14:06
 * @version: 1.0
 */
@Slf4j
public class TestCompletableFuture {

    public static void main(String[] args) throws Exception {
        test4();
    }


    public static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<String> f = future.thenApplyAsync(i -> i * 10).thenApply(i -> i.toString());
        System.out.println(f.get());
    }

    public static void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {

            log.info("====1111======");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            log.info("=====222222=====");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        CompletableFuture<String> f = future.thenCombine(future2, (x, y) -> {
            log.info("===聚合=======");
            return y + "-" + x;
        });
        System.out.println(f.get());
    }


    public static void test3() throws ExecutionException, InterruptedException {


        List<CompletableFuture<String>> futureList = new ArrayList<>();

        futureList.add(CompletableFuture.supplyAsync(() -> "123"));
        futureList.add(CompletableFuture.supplyAsync(() -> "123"));
        futureList.add(CompletableFuture.supplyAsync(() -> "123"));

        CompletableFuture<Void> result = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));

        System.out.println("result = " + result.get());

    }

    /**
     * 主要完成线程池执行多个任务使用CompletableFuture
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void test4() throws ExecutionException, InterruptedException {

        List<CompletableFuture<Integer>> futureList = new ArrayList<>();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("任务");

        final int[] sum = {0};

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30, 40, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));

        for (int i = 0; i < 30; i++) {
            CompletableFuture<Integer> futureTemp = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return new Random().nextInt(10 - 1) + 1;
            }, threadPoolExecutor).whenComplete((result, throwAble) -> {
                sum[0] = sum[0] + result;
            });
            futureList.add(futureTemp);
        }

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]))
                .thenRun(() -> System.out.println("完成！！！！"))
                .join();

        stopWatch.stop();
        threadPoolExecutor.shutdown();
        System.out.println(stopWatch.getTotalTimeSeconds());

        log.info("result = " + sum[0]);
    }


}
