package com.gaga;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池单列模式
 *
 * @author ：liujia
 * @date ：Created in 2020/9/26 15:03
 * @version: 1.0
 */
public class ExcutorFactory {

    /**
     * 生产者线程池
     */
    private volatile static ThreadPoolExecutor instanceProducter;
    /**
     * 消费者线程池
     */
    private volatile static ThreadPoolExecutor instanceConsumer;

    //双重锁作用，
    // 1、提交效果
    // 2、volatile防止不可见性的问题

    public static ThreadPoolExecutor getProducterInstance(int corePoolSize) {
        if (instanceProducter == null) {
            //使用类锁，可能存在一个性能问题，但是影响不大
            synchronized (ExcutorFactory.class) {
                if (instanceProducter == null) {
                    instanceProducter = (ThreadPoolExecutor) Executors.newFixedThreadPool(corePoolSize);
                }
            }
        }
        return instanceProducter;
    }

    public static ThreadPoolExecutor getConsumerInstance(int corePoolSize) {
        if (instanceConsumer == null) {
            synchronized (ExcutorFactory.class) {
                if (instanceConsumer == null) {
                    instanceConsumer = (ThreadPoolExecutor) Executors.newFixedThreadPool(corePoolSize);
                }
            }
        }
        return instanceConsumer;
    }


}
