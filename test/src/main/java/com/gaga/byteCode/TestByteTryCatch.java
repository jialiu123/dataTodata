package com.gaga.byteCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 这个try catch 主要演示的是 去除finally写法的，比如这个列子就不需要写finally的中的colse方法
 * 但是对象必须实现 AutoCloseable接口
 *
 * @author ：liujia
 * @date ：Created in 2021/1/28 20:43
 * @description：TODO
 * @version: 1.0
 */
public class TestByteTryCatch {

    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream(new File("123"))) {

        } catch (IOException e) {

        }

    }


}
