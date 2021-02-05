package com.gaga.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * unpark 相当于补给干粮
 * park相当于消费干粮 如果没有干粮可以消费 那么进行休息区等待
 * 底层实现是C++的PARK类
 * <p>
 * 每个线程都会维护一个这个PARK类
 * PARK 又分为COUNT区域和休息区于 每次unpark 就会COUNT = 1
 * 每次park COUNT-- 如果COUNT==0 那么进入休息区
 * <p>
 * 进入休息区的状态是WAIT
 *
 * @author ：liujia
 * @date ：Created in 2021/2/4 21:40
 * @description：测试lockSupport
 * @version: 1.0
 */
@Slf4j
public class TestLockSupport {

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            log.debug("暂停");
            LockSupport.park();
            log.debug("运行结束");

        }, "线程1");
        t1.start();

        Thread.sleep(1000);
        LockSupport.unpark(t1);
        log.debug("重置");
    }

}
