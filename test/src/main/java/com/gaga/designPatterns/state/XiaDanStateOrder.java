package com.gaga.designPatterns.state;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/19 13:24
 * @version: 1.0
 */
public class XiaDanStateOrder implements Order {
    @Override
    public void handle() {
        System.out.println("下单处理流程");
    }
}
