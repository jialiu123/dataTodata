package com.gaga.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆空间溢出演示 java.lang.OutOfMemoryError: Java heap space
 * <p>
 * 配置参数 -Xms8m 初始化大小
 * -Xmx 最大值
 * -Xms 最小值
 *
 * @author ：liujia
 * @date ：Created in 2021/1/26 9:02
 * @version: 1.0
 */
public class HeapOutTest {

    public static void main(String[] args) throws InterruptedException {
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            studentList.add(new Student());
        }
        Thread.sleep(100000L);
    }
}

class Student {
    private byte[] name = new byte[1024 * 1024 * 100];
}
