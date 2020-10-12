package com.gaga.designPatterns.factory;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:07
 * @description：TODO
 * @version: 1.0
 */
public class MacPc implements Pc {
    @Override
    public void make() {
        System.out.println("make mac pc");
    }
}
