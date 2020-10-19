package com.gaga.designPatterns.state;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/19 13:27
 * @version: 1.0
 */
public class StateTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.XiaDan();
        context.getFileState();
        context.Fahuo();
        context.getFileState();
    }

}
