package com.gaga.byteCode;

import com.gaga.jdk8.Student;

/**
 * 主要样式匿名内部内的情况，会多生成一个Class文件，一般是主文件的$序号
 * 并且匿名内部内中 调用外部引用只能是final的
 * 是因为内部内的参数引用是通过构造方法进去的，如果外部x可以随意改变，那么里面的$varx不会随之而改变，就会出现问题
 * 但是如果传入对象就不一样了，对象是引用哦，可以对对象进行改变的
 * public class CLass$1{
 * int $varx;
 * Class$1(int x){
 * this.$varx = x;
 * }
 * }
 *
 * @author ：liujia
 * @date ：Created in 2021/1/28 20:43
 * @version: 1.0
 */
public class TestByte匿名内部类 {

    public static void main(String[] args) throws InterruptedException {

        Student student = new Student("1", 2, "2");

        int i = 0;

        Runnable runnable = () -> {
            System.out.println(i);
//            i++;
            student.setAge(33);
        };
        runnable.run();

        Thread.sleep(1000);

        System.out.println(student.getAge());

    }


}
