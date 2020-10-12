package com.gaga.designPatterns.factory;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:07
 * @description：TODO
 * @version: 1.0
 */
public class PcFactory {

    //感觉有点像静态代理
    private Pc pc;

    public PcFactory(Pc pc) {
        this.pc = pc;
    }

    public void make() {
        pc.make();
    }
}
