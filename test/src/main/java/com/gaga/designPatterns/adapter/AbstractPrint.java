package com.gaga.designPatterns.adapter;

/**
 * @author ：liujia
 * @date ：Created in 2021/1/22 13:18
 * @description：TODO
 * @version: 1.0
 */
public abstract class AbstractPrint implements Print {

    @Override
    public void print(String printContent) {
        System.out.println(printContent);
    }
}
