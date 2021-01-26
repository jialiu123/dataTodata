package com.gaga.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * 直接内存测试
 * <p>
 * Unsafe方法没办法直接使用 需要通过反射才能弄出来
 *
 * <p>
 * 底层实现是借助Unsafe中的分配内存和释放内存方法
 * 释放内存是通过虚引用Cleaner类 JVM会主动调用clean方法 然后在调用现场Deallocator中的run方法 释放内存
 * <p>
 * 对于直接内存这一块 我在想如果做数据抽取 是否可以直接使用这种方式，
 * 比如读取数据流，然后写到直接内存，直接操作避免JVM溢出问题
 *
 * @author ：liujia
 * @date ：Created in 2021/1/26 13:42
 * @version: 1.0
 */
public class ByteBuffterTest {

    public static void main(String[] args) {

        Unsafe unsafe = getUnsafe();

        System.out.println(Runtime.getRuntime().freeMemory());

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024 * 10);

        System.out.println("使用JVM内存");
        System.out.println(Runtime.getRuntime().freeMemory());

        ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(1024 * 1024 * 10);

        System.out.println("使用直接内存");

        System.out.println(Runtime.getRuntime().freeMemory());
    }


    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }

}
