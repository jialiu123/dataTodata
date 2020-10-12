package com.gaga.designPatterns.factory;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 16:25
 * @description：工厂模式
 * @version: 1.0
 */
public class FactoryTest {

    public static void main(String[] args) {
        PcFactory pcFactory = new PcFactory(new MacPc());
        pcFactory.make();
    }

}
