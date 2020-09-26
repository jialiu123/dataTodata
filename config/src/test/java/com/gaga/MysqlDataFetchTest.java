package com.gaga;

import com.gaga.fetch.mysql.MysqlDataFetch;
import org.junit.Test;

import java.util.Random;

/**
 * @author ：liujia
 * @date ：Created in 2020/9/25 8:57
 * @version: 1.0
 */
public class MysqlDataFetchTest {

    @Test
    public void testMysSql() {


    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                MysqlDataFetch mysqlDataFetch = new MysqlDataFetch(new Random().nextInt(10 - 1) + 1);
                System.out.println(mysqlDataFetch.getCoreSize());
            }).start();
        }
    }


}
