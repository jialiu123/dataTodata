package com.gaga.designPatterns.singleton;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 16:25
 * @description：单例模式
 * @version: 1.0
 */
public class SingletonTest {

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + Student.getInstance().hashCode());
            }, "name" + i).start();
        }
    }

}

class Student {


    /**
     * private不允许通过new创建
     */
    private Student() {
    }

    private static volatile Student instance;

    /**
     * 双重锁作用
     * 提高效果
     *
     * @return
     */
    public static Student getInstance() {

        if (instance == null) {
            //使用类锁，可能存在一个性能问题，但是影响不大
            synchronized (Student.class) {
                if (instance == null) {
                    instance = new Student();
                }
            }
        }
        return instance;
    }
}

