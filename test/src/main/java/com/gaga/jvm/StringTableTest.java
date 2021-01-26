package com.gaga.jvm;

import org.junit.Test;

/**
 * 字符串常量池测试 只描述jdk1.8实现
 * <p>
 * 字符串 常量池 底层实现是HashTable
 *
 * @author ：liujia
 * @date ：Created in 2021/1/26 8:51
 * @version: 1.0
 */
public class StringTableTest {


    @Test
    //["liujia","yiyi","liujiayiyi"]
    public void test() {
        String s1 = "liujia";
        String s2 = "yiyi";

        //底层实现  //new StringBuilder().append("liujia").append("yiyi").toString()
        //这种方式 会最终落到堆中
        String s3 = s1 + s2;
        //会落到字符串常量池中
        String s4 = "liujia" + "yiyi";

//        System.out.println(s3 == s4);

        //intern 尝试放进字符串常量池中 s5返回的其实就是 liujiayiyi
        // 存在2中情况 如果s3放置成功 那么 s3==s4为true，如果没有放置成功 s3==s4为false
        //目前代码这种情况 常量池中已经存在 liujiayiyi 那么s3其实没有放置成功 那么s3==s4为fasle
        String s5 = s3.intern();

        System.out.println(s3 == s4);
        System.out.println(s5 == s4);

    }

}
