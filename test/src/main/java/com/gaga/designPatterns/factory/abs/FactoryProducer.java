package com.gaga.designPatterns.factory.abs;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:26
 * @description：TODO
 * @version: 1.0
 */
public class FactoryProducer {

    public static Factory getFactory(String choice) {
        if (choice.equalsIgnoreCase("pc")) {
            return new PcFactory();
        } else if (choice.equalsIgnoreCase("mouse")) {
            return new MouseFactory();
        }
        return null;
    }
}
