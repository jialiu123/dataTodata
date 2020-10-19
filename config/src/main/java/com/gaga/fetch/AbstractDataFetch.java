package com.gaga.fetch;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ：liujia
 * @date ：Created in 2020/9/7 17:21
 * @version: 1.0
 */
public abstract class AbstractDataFetch implements DataFetch {

    @Getter
    @Setter
    protected int coreSize;

    @Override
    public void handle() {
        //自己处理逻辑
        System.out.println("开始处理公共逻辑");
    }
}
