package com.gaga.reflect;

import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：liujia
 * @date ：Created in 2021/1/28 21:35
 * @description：TODO
 * @version: 1.0
 */
public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {

        for (Class<?> aClass : String.class.getClasses()) {
            System.out.println(aClass);
        }

        System.out.println("=========================");

        for (Method declaredMethod : String.class.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        System.out.println("=========================");

        for (Field declaredField : String.class.getDeclaredFields()) {
            System.out.println(declaredField);
        }

        System.out.println("=========================");

        System.out.println(Reflection.getCallerClass());

        System.out.println("=========================");
        Method valueOfMethod = String.class.getMethod("valueOf", Object.class);

        System.out.println(valueOfMethod.invoke(Class.forName("java.lang.String"), "123"));

    }

}
