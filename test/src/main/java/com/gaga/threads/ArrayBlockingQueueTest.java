package com.gaga.threads;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author ：liujia
 * @date ：Created in 2021/2/5 16:00
 * @version: 1.0
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(10);


        //add put offer
        //remove take poll

        //add方法如果满了 就直接报异常 java.lang.IllegalStateException: Queue full
//        for (int i = 0; i < 12; i++) {
//            arrayBlockingQueue.add("1");
//        }


        //put方法 如果满了，就塞不进去了，直接阻塞
//        for (int i = 0; i < 12; i++) {
//            arrayBlockingQueue.put("1");
//        }

        //offer 方法 不会阻塞 但是如果满了 塞不进去 就直接返回false
//        for (int i = 0; i < 12; i++) {
//            System.out.println(arrayBlockingQueue.offer("1"));
//        }

        for (int i = 0; i < 2; i++) {
            arrayBlockingQueue.offer("1");
        }
        //remove方法 如果拿不到的话 直接报错
//        for (int i = 0; i < 3; i++) {
//            String remove = arrayBlockingQueue.remove();
//            System.out.println(remove);
//        }

        //take 拿不到会陷入阻塞
//        for (int i = 0; i < 3; i++) {
//            String take = arrayBlockingQueue.take();
//            System.out.println(take);
//        }

        //poll 拿不到不会阻塞 直接返回null
        for (int i = 0; i < 3; i++) {
            String poll = arrayBlockingQueue.poll();
            System.out.println(poll);
        }

        arrayBlockingQueue.stream().forEach(item -> System.out.println(item));


    }
}
