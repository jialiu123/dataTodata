package com.gaga.threads;

import java.util.concurrent.Exchanger;

/**
 * Exchange用于两个线程交换数据，
 * 不能用于多个线程之间交换数据
 *
 * @author ：liujia
 * @date ：Created in 2020/10/14 14:49
 * @version: 1.0
 */
public class ExchangeTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread left = new Thread(() -> {
            try {
                String result = exchanger.exchange("left tell right : I give you 100");
                System.out.println("left Thread get : " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        left.start();
        Thread right = new Thread(() -> {
            try {
                String result = exchanger.exchange("right tell left : I give you 300");
                System.out.println("right Thread get : " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        right.start();
    }

}
