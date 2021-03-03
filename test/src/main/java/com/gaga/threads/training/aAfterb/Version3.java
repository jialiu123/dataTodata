package com.gaga.threads.training.aAfterb;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * 实现先输出a 在输出b  LockSupport版本的实现
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 22:18
 * @version: 1.0
 */
@Slf4j
public class Version3 {

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {

            LockSupport.park();
            log.debug("b");

        }, "b");
        t1.start();

        new Thread(() -> {
            log.debug("a");
            LockSupport.unpark(t1);
        }, "a").start();
    }
}


