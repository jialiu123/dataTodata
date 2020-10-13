package com.gaga.designPatterns.observer;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 11:08
 * @description：观察者模式
 * @version: 1.0
 */
public class ObserverTest {

    public static void main(String[] args) {
        User user = new User();
        user.addObserver(new UserObserver());
        user.change();
    }

}
