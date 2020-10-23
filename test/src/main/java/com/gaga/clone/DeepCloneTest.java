package com.gaga.clone;

import com.alibaba.fastjson.JSON;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:42
 * @description：深拷贝
 * @version: 1.0
 */
public class DeepCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        method2();
    }

    public static void method1() throws CloneNotSupportedException {

        Order order = new Order(1, "2", 2, new OrderDetail(1, 2));

        Order order2 = (Order) order.clone();

        System.out.println("order.hashCode() : " + order.hashCode());
        System.out.println("order2.hashCode() : " + order2.hashCode());

        String result = order.hashCode() == order2.hashCode()
                ? "clone是浅拷贝的" : "clone是深拷贝的";

        System.out.println(result);

        order2.setOrderId(2);
        order2.setOrderMoney("3");

        System.out.println(order.toString());
        System.out.println(order2.toString());
    }


    public static void method2() throws CloneNotSupportedException {

        Order order = new Order(1, "2", 2, new OrderDetail(1, 2));

        Order order2 = deepStream(order);
        order2.setOrderMoney("3");

        System.out.println("order.hashCode() : " + JSON.toJSONString(order));
        System.out.println("order2.hashCode() : " + JSON.toJSONString(order2));
    }

    public static <T> T deepStream(T object) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
