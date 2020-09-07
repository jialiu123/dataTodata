package com.gaga.config.mybaitsplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final String FORMAT_EDATE = "yyyy-MM-dd HH:mm:SS";

    @Override
    public void insertFill(MetaObject metaObject) {

//        this.setFieldValByName("tjsj", DateUtil.format(new Date(), FORMAT_EDATE), metaObject);
//        this.setFieldValByName("jlzt", 0, metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName("gxsj", DateUtil.format(new Date(), FORMAT_EDATE), metaObject);
    }

}