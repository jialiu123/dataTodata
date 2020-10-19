package com.gaga.fetch.mysql;

import com.gaga.fetch.AbstractDataFetch;

/**
 * @author ：liujia
 * @date ：Created in 2020/9/7 17:23
 * @version: 1.0
 */
public class MysqlDataFetch extends AbstractDataFetch {


    public MysqlDataFetch() {
        this(Runtime.getRuntime().availableProcessors() - 1);
    }

    public MysqlDataFetch(int coreSize) {
        this.coreSize = coreSize;
    }

    @Override
    public void handle() {
        super.handle();
        //自己处理逻辑
        System.out.println("开始自己处理逻辑");

    }
}
