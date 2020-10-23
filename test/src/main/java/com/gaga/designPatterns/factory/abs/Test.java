package com.gaga.designPatterns.factory.abs;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:27
 * @description：TODO
 * @version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        Factory pcFactory = FactoryProducer.getFactory("pc");
        pcFactory.createPc(1);

        Factory mouseFactory = FactoryProducer.getFactory("mouse");
        mouseFactory.createMouse(1);
    }
}
