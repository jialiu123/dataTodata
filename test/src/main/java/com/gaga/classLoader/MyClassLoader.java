package com.gaga.classLoader;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/19 14:08
 * @version: 1.0
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) {
        ClassLoader loader = MyClassLoader.class.getClassLoader();

        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }

        System.out.println("---");
        // 尝试访问核心库类的类加载器
        System.out.println(Integer.class.getClassLoader());

    }


}


