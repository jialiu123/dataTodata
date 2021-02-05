package com.gaga.byteCode;

import java.lang.reflect.Method;

/**
 * 该例子主要是为了证明@Override 返回类型不同 JVM给我们做的特殊处理，其实
 * Class B中会生成2个方法 一个属于桥接方法，对于开发是不可见的 关键字为 synthetic bridge 桥接
 * <p>
 * 在实际重写的方法中调用了 另外一个Integer的m方法
 *
 * @author ：liujia
 * @date ：Created in 2021/1/28 20:43
 * @version: 1.0
 */
public class TestByteTryOverride {

    public static void main(String[] args) {


        for (Method m : B.class.getDeclaredMethods()) {
            System.out.println(m);
        }

        //结果
        //public java.lang.Integer com.gaga.byteCode.B.test()
        //public java.lang.Number com.gaga.byteCode.B.test()


    }

}

class A {
    public Number test() {
        return 1;
    }
}

class B extends A {
    @Override
    public Integer test() {
        return 2;
    }
}
