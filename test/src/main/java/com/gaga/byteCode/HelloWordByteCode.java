package com.gaga.byteCode;

/**
 * @author ：liujia
 * @date ：Created in 2021/1/28 9:17
 * @version: 1.0
 */
public class HelloWordByteCode {


    /**
     * 该例子方便理解字节码 基本操作
     */
    public void test1() {
        int i = 0;
        i = i++;
        System.out.println(i);
    }

    /**
     * 该例子进一步深入了解
     */
    public void test2() {
        int x = 0;
        for (int i = 0; i < 10; i++) {
            x = x++;
        }
        System.out.println(x);
    }


}
