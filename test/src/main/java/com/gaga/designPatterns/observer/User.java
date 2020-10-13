package com.gaga.designPatterns.observer;

import java.util.Observable;

/**
 * 被观察者
 *
 * @author ：liujia
 * @date ：Created in 2020/10/12 11:08
 * @version: 1.0
 */
public class User extends Observable {


    public void change() {
        this.setChanged();
        this.notifyObservers();
    }

}
