package com.gaga.javap;

/**
 * @author ：liujia
 * @date ：Created in 2021/1/22 9:00
 * @version: 1.0
 */
public class TestJavaP {

    public static void main(String[] args) {

        String lock = new String();

        synchronized (lock) {
            System.out.println(1111);
        }


    }


}
