package com.gaga.jvm.reference;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * -Xmx16m -XX:+PrintGCDetails -verbose:gc
 * 软引用解决内存不足的情况
 *
 * @author ：liujia
 * @date ：Created in 2021/1/26 20:15
 * @version: 1.0
 */
public class SoftReferenceTest {

    static final int _4MB = 1024 * 1024 * 4;

    public static void main(String[] args) throws Exception {

//        test();
        softTest();
    }

    static void test() {
        ArrayList<byte[]> list = new ArrayList();
        for (int i = 0; i < 4; i++) {
            list.add(new byte[_4MB]);
        }
    }

    static void softTest() throws InterruptedException, IOException {
        ReferenceQueue referenceQueue = new ReferenceQueue();

        ArrayList<SoftReference<byte[]>> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            //关联了引用队列 如果回收的时候 软引用就会加入队列中
            list.add(new SoftReference(new byte[_4MB], referenceQueue));
        }

        Reference poll = referenceQueue.poll();

        while (null != poll) {
            list.remove(poll);
            poll = referenceQueue.poll();
        }

        list.forEach(item -> System.out.println(item.get()));

        //  System.in.read();

    }


}
