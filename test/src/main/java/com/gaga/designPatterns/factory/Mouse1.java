package com.gaga.designPatterns.factory;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:05
 * @version: 1.0
 */
public class Mouse1 implements Mouse {
    @Override
    public void create() {
        System.out.println("开始制造鼠标1");
    }
}
