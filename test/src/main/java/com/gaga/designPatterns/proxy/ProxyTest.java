package com.gaga.designPatterns.proxy;

import com.gaga.designPatterns.proxy.staticProxy.Student;
import com.gaga.designPatterns.proxy.staticProxy.StudentProxy;

/**
 * 代理模式分为静态代理和动态代理
 * 动态代理可以分为不同种的实现：jdk实现和
 *
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:12
 * @description：代理模式
 * @version: 1.0
 */
public class ProxyTest {
    public static void main(String[] args) {
        //静态代理测试
        StudentProxy studentProxy = new StudentProxy(new Student());

        studentProxy.play();

    }
}
