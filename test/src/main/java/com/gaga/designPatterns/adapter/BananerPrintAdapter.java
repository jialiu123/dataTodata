package com.gaga.designPatterns.adapter;

/**
 * @author ：liujia
 * @date ：Created in 2021/1/22 13:11
 * @description：TODO
 * @version: 1.0
 */
public class BananerPrintAdapter extends AbstractPrint {

    private Bananer bananer;

    public BananerPrintAdapter(Bananer bananer) {
        this.bananer = bananer;
    }

    public void printBananer() {
        super.print(this.bananer.getName());
    }

}
