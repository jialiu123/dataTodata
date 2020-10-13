package com.gaga.designPatterns.proxy;

import com.gaga.designPatterns.proxy.dynamicProxy.CglibProxy;
import com.gaga.designPatterns.proxy.dynamicProxy.JdkProxyHandler;
import com.gaga.designPatterns.proxy.staticProxy.Person;
import com.gaga.designPatterns.proxy.staticProxy.Student;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 8:54
 * @description：动态代理测试
 * @version: 1.0
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

        Person person = new Student();

        InvocationHandler handler = new JdkProxyHandler(person);

        Person proxyStudent = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), handler);

        proxyStudent.play();


        CglibProxy cglibProxy = new CglibProxy();
        Person cglibProxyStudent = (Person) Enhancer.create(person.getClass(), cglibProxy);
        cglibProxyStudent.play();


    }

}
