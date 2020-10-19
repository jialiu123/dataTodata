package com.gaga.designPatterns.facade;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/19 14:17
 * @version: 1.0
 */
public class Facade {

    private UserInfoService userInfoService;

    private OrderInfoService orderInfoService;


    public UserInfoService getUserInfoService() {
        return new UserInfoService();
    }

    public OrderInfoService getOrderInfoService() {
        return new OrderInfoService();
    }
}
