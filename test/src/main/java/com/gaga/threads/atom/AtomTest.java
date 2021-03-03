package com.gaga.threads.atom;

import lombok.Data;

import java.math.BigDecimal;
import java.util.concurrent.atomic.*;

/**
 * @author ：liujia
 * @date ：Created in 2021/3/2 13:09
 * @version: 1.0
 */
public class AtomTest {

    private static AtomicInteger test = new AtomicInteger();

    private static AtomicBoolean test2 = new AtomicBoolean();

    private static AtomicLong test3 = new AtomicLong();

    private static AtomicIntegerArray testIntegerArray = new AtomicIntegerArray(3);

    private static AtomicLongArray testLongArray = new AtomicLongArray(3);

    private static AtomicReference<BigDecimal> testObject = new AtomicReference();

    //状态位更新
    private static AtomicMarkableReference<BigDecimal> testObject2 = new AtomicMarkableReference(new BigDecimal(0), false);

    //信号量状态更新
    private static AtomicStampedReference<BigDecimal> testObject3 = new AtomicStampedReference(new BigDecimal(0), 0);


    //属性更新
    private static AtomicIntegerFieldUpdater<Student> testFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");


    //专门用作累加的，多维护一个数组的累加器，类似分批工作思路一样，减少竞争
    private static LongAdder longAdderTest = new LongAdder();


    public static void main(String[] args) {


//        System.out.println(test.incrementAndGet());
//
//        System.out.println(test2.get());
//        System.out.println(test3.get());


        Student student = new Student();

        testFieldUpdater.updateAndGet(student, (x) -> {
            return x + 10;
        });
        System.out.println(student.getAge());

        longAdderTest.add(2);

        System.out.println(longAdderTest.sum());


    }


    @Data
    private static class Student {
        String name;
        volatile int age;
    }

}
