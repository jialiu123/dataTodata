package com.gaga.designPatterns.proxy.dynamicProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 9:12
 * @description：Cglib实现动态代理
 * @version: 1.0
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Before invoke " + method.getName());
        methodProxy.invokeSuper(object, objects);
        System.out.println("After invoke " + method.getName());
        return null;

    }
}
