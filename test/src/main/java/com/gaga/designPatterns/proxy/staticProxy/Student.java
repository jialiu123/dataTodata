package com.gaga.designPatterns.proxy.staticProxy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:15
 * @version: 1.0
 */
public class Student implements Person {
    @Override
    public void play() {
        System.out.println("学生开始玩了");
    }
}
