package com.gaga.designPatterns.factory;

import com.alibaba.fastjson.JSON;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 16:25
 * @description：工厂模式
 * @version: 1.0
 */
public class FactoryTest {

    public static void main(String[] args) {
        Pc pc = PcFactory.PcFactory(1);
        pc.make();


        JSON.parseObject("{}", Pc.class);


    }

}
