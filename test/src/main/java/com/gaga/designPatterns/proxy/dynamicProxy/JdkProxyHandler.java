package com.gaga.designPatterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 8:56
 * @description：jdk实现的动态代理
 * @version: 1.0
 */
public class JdkProxyHandler implements InvocationHandler {

    private Object object;

    public JdkProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Before invoke " + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());

        return null;
    }
}
