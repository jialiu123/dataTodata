package com.gaga.designPatterns.facade;

/**
 * 外观模式
 *
 * @author ：liujia
 * @date ：Created in 2020/10/19 14:04
 * @version: 1.0
 */
public class FacadeTest {

    static final Facade facade = new Facade();

    public static void main(String[] args) {

        facade.getOrderInfoService().getList();

        facade.getUserInfoService().getList();

    }

}
