package com.gaga.jvm;

/**
 * @author ：liujia
 * @date ：Created in 2021/1/27 14:22
 * @description：TODO
 * @version: 1.0
 */
public class TestStringTable {

    public static void main(String[] args) {

        // [1,2,12] 字符串常量池
        String a = "1";
        String b = "2";
        String d = a + b; //堆
        String c = "1" + "2";
        String e = d.intern();


        System.out.println(c == d); //false
        System.out.println(c == e); // true
        System.out.println(d == e); //false


    }

}
