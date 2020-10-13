package com.gaga.designPatterns.strategy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 10:56
 * @description：TODO
 * @version: 1.0
 */
public class MemberStrategyContext {

    private MemberStrategy memberStrategy;

    public MemberStrategyContext(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    void calcPrice(double booksPrice) {
        this.memberStrategy.calcPrice(booksPrice);
    }
}
