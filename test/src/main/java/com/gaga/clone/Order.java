package com.gaga.clone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:43
 * @description：TODO
 * @version: 1.0
 */
@Getter
@Setter
@AllArgsConstructor
public class Order implements Cloneable, Serializable {

    private int orderId;

    private String orderMoney;

    private int orderType;

    private OrderDetail orderDetail;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Order) super.clone();
    }
}

@Getter
@Setter
@AllArgsConstructor
class OrderDetail implements Serializable {

    private int orderDetailId;

    private int orderId;

}

