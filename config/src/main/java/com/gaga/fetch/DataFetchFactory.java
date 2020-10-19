package com.gaga.fetch;

import com.gaga.fetch.mysql.MysqlDataFetch;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/19 14:43
 * @version: 1.0
 */
public class DataFetchFactory {

    private DataFetch dataFetch;

    private DataFetchFactory(DataFetch dataFetch) {
        this.dataFetch = dataFetch;
    }

    public void handle() {
        this.dataFetch.handle();
    }

    public static void main(String[] args) {
        DataFetchFactory dataFetchFactory = new DataFetchFactory(new MysqlDataFetch());
        dataFetchFactory.handle();
    }

}
