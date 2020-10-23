package com.gaga.clone;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:43
 * @description：浅拷贝测试
 * @version: 1.0
 */
public class ShallowCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        Order order3 = new Order(3, "2", 2, new OrderDetail(1, 2));
        Order order4 = order3;

        order4.setOrderId(4);

        System.out.println(order3.hashCode());
        System.out.println(order4.hashCode());


    }
}
