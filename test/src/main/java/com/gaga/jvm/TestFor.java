package com.gaga.jvm;

/**
 * @author ：liujia
 * @date ：Created in 2021/1/27 14:08
 * @description：TODO
 * @version: 1.0
 */
public class TestFor {

    public static void main(String[] args) {

        //1
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
        }

        //2
        Student student = null;
        for (int i = 0; i < 10; i++) {
            student = new Student();
        }
    }

    static class Student {
        String name;
    }

}
