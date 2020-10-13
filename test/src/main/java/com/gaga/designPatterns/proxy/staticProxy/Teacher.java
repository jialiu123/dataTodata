package com.gaga.designPatterns.proxy.staticProxy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 8:50
 * @version: 1.0
 */
public class Teacher implements Person {
    @Override
    public void play() {
        System.out.println("老师开始玩了");
    }
}
