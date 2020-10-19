package com.gaga.designPatterns.factory;

/**
 * 工厂模式是用来创建对象的
 *
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:07
 * @version: 1.0
 */
public class PcFactory {

    public static Pc PcFactory(int type) {
        if (type == 1) {
            return new MacPc();
        } else if (type == 2) {
            return new WindowPc();
        }

        return null;
    }

}
