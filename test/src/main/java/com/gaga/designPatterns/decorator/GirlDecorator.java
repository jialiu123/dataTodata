package com.gaga.designPatterns.decorator;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/13 14:23
 * @version: 1.0
 */
public class GirlDecorator {
    private Girl girl;

    public GirlDecorator(Girl girl) {
        this.girl = girl;
    }

    public void say() {
        this.girl.say();
        System.out.println("说英文");
    }
}
