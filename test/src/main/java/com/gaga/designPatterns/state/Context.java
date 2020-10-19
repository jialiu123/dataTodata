package com.gaga.designPatterns.state;

/**
 * 感觉真的策略模式太像了 一个是固定的，一个是动态的
 * 自己真的感觉不出来有啥区别
 *
 * @author ：liujia
 * @date ：Created in 2020/10/19 13:25
 * @version: 1.0
 */
public class Context {
    private Order orderState;

    public void XiaDan() {
        this.orderState = new XiaDanStateOrder();
    }

    public void Fahuo() {
        this.orderState = new FaHuoStateOrder();
    }

    /**
     * 获取当前文件的状态
     */
    public void getFileState() {
        orderState.handle();
    }
}
