package com.gaga.designPatterns.factory.simple;

import com.alibaba.fastjson.JSON;
import com.gaga.designPatterns.factory.Pc;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 16:25
 * @description：简单工厂模式
 * @version: 1.0
 */
public class FactoryTest {

    public static void main(String[] args) {
        Pc pc = PcFactory.PcFactory(1);
        pc.make();

        JSON.parseObject("{}", Pc.class);
    }

}
