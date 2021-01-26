package com.gaga.jvm;

/**
 * 栈是一个先进后出的数据结构
 * 主要是有一个个的栈针进行组成的，每一个方法对应的就是一个栈针
 * 一个栈对应的就是一个栈针，并且他是不需要进行垃圾回收的
 * <p>
 * 栈空间溢出演示 java.lang.StackOverflowError
 * 栈溢出的演示 很麻烦 无限递归会导致栈溢出
 * <p>
 * -Xss1m
 *
 * @author ：liujia
 * @date ：Created in 2021/1/26 13:30
 * @version: 1.0
 */
public class StackOutTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        test();
    }

}
