package com.gaga;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 继承Application接口后项目启动时会按照执行顺序执行run方法
 * 通过设置Order的value来指定执行的顺序
 */
@Component
@Order(value = 1)
public class StartService implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //springboot启动完成之后，运行该方法，目前啥也没写
    }

}