package com.gaga.fetch;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ：liujia
 * @date ：Created in 2020/9/7 17:21
 * @description：TODO
 * @version: 1.0
 */
public abstract class AbstractDataFetch implements DataFetch {


    @Getter
    @Setter
    protected int coreSize;
}
