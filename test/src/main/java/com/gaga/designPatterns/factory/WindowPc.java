package com.gaga.designPatterns.factory;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:06
 * @version: 1.0
 */
public class WindowPc implements Pc {
    @Override
    public void make() {
        System.out.println("make window pc");
    }
}
