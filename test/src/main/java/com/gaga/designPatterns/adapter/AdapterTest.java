package com.gaga.designPatterns.adapter;

/**
 * 主要是把2个不相关的功能结合起来对外暴露使用
 *
 * @author ：liujia
 * @date ：Created in 2020/10/12 13:07
 * @description：桥接设计模式测试
 * @version: 1.0
 */
public class AdapterTest {

    public static void main(String[] args) {

        BananerPrintAdapter bananerPrintAdapter = new BananerPrintAdapter(new Bananer("123"));
        bananerPrintAdapter.printBananer();
    }

}
