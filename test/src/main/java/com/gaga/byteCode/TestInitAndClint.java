package com.gaga.byteCode;

/**
 * clinit 是类的构造方法 类构造器方法
 * init 是对象构造方法
 * <p>
 * init是对象构造器方法，也就是说在程序执行 new 一个对象调用该对象类的 constructor 方法时才会执行init方法，
 * 而clinit是类构造器方法，也就是在jvm进行类加载—–验证—-解析—–初始化，中的初始化阶段jvm会调用clinit方法。
 * https://blog.csdn.net/u013309870/article/details/72975536
 *
 * @author ：liujia
 * @date ：Created in 2021/1/29 9:50
 * @version: 1.0
 */
public class TestInitAndClint {

    public static void main(String[] args) throws ClassNotFoundException {
//        InitAndClint initAndClint = new InitAndClint();

//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        classLoader.loadClass("com.gaga.byteCode.InitAndClint");

        InitAndClint initAndClint = new InitAndClint();
        Son son = new Son();
    }
}

class InitAndClint {

    private int i = 0;
    private static int j = 1;

    InitAndClint() {
        System.out.println("调用init");
    }

    static {
        System.out.println("调用clinit");
    }
}

//class InitAndClint {
//
//    // 对象构造
//    init() {
//        int i = 0;
//        System.out.println("调用init");
//    }
//
//    //类构造
//    clinit() {
//        int j = 1;
//        System.out.println("调用clinit");
//    }
//
//}


class Father {

    private static int j = 1;

    //调用FatherClint
    //调用SonClint
    //调用FatherInit
    //调用SonInit

    //很奇怪 为啥 先FatherInit,是因为 放在了父类的Clint中了
    static Son son = new Son();

    //调用FatherInit
    //调用SonInit
    //调用FatherClint
    //调用SonClint
    //调用FatherInit
    //调用SonInit


    static {
        System.out.println("调用FatherClinit");
    }

    Father() {
        System.out.println("调用FatherInit");
    }
}

class Son extends Father {

    private static int j = 1;

    static {
        System.out.println("调用SonClinit");
    }

    Son() {
        System.out.println("调用SonInit");
    }
}
