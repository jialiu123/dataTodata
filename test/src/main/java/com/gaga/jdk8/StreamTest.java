package com.gaga.jdk8;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream 测试
 *
 * @author ：liujia
 * @date ：Created in 2020/10/14 15:27
 * @version: 1.0
 */
@Slf4j
public class StreamTest {

    private static List<Student> studentList = Arrays.asList(
            new Student("张三", 26, "男"),
            new Student("李四", 22, "女"),
            new Student("王二", 25, "男"),
            new Student("麻子", 78, "男")
    );

    public static void main(String[] args) {

        log.info("================forEach===============");
        //forEach 接收一个参数，只是循环没有返回值
        // 底层实现Consumer<T>：消费型接口（void accept(T t)）
        studentList.stream().forEach(item -> log.info(item.getSex()));

        log.info("===================map============");
        //map 接收一个参数，返回一个参数
        // 底层实现 Function<T, R>：函数型接口（R apply（T t））
        studentList.stream().map(item -> {
            return item.getAge() + 10;
        }).forEach(item -> log.info(item.toString()));

        log.info("===================filter============");
        //filter 过滤数据
        // 底层实现 Predicate<T>：断言型接口
        studentList.stream().filter(item -> {
            return item.getAge() > 22;
        }).forEach(item -> log.info(item.toString()));

        log.info("===================collect============");
        //collect 收集数据
        studentList.stream().collect(Collectors.toList());


//        //先造一个flatMap数据吧
        List<List<String>> wordCountList = Arrays.asList(
                Arrays.asList("abc", "bcd", "aca"),
                Arrays.asList("abc", "bcd", "aca")
        );

        log.info("===================collect============" + wordCountList.size());
        //collect 收集数据
        wordCountList.stream().flatMap(item -> {
            return item.stream().map(y -> y.replace("鸡", "煎"));
        }).forEach(x -> System.out.println(x));


    }

}
