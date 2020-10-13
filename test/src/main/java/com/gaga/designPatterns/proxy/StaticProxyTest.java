package com.gaga.designPatterns.proxy;

import com.gaga.designPatterns.proxy.staticProxy.PersonProxy;
import com.gaga.designPatterns.proxy.staticProxy.Student;
import com.gaga.designPatterns.proxy.staticProxy.Teacher;

/**
 * 代理模式分为静态代理和动态代理
 * 动态代理可以分为不同种的实现：jdk实现和
 *
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:12
 * @description：静态代理模式测试
 * @version: 1.0
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //静态代理测试
        PersonProxy studentProxy = new PersonProxy(new Student());

        studentProxy.play();


        //静态代理测试
        PersonProxy teacherProxy = new PersonProxy(new Teacher());

        teacherProxy.play();

    }
}
