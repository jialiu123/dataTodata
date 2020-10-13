package com.gaga.designPatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 *
 * @author ：liujia
 * @date ：Created in 2020/10/12 11:13
 * @version: 1.0
 */
public class UserObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        User user = (User) o;

        System.out.println("=========user对象被观察了======" + user.hashCode());
    }

}
