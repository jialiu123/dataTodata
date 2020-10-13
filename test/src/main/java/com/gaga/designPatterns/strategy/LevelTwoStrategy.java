package com.gaga.designPatterns.strategy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 10:54
 * @version: 1.0
 */
public class LevelTwoStrategy implements MemberStrategy {
    @Override
    public void calcPrice(double booksPrice) {
        System.out.println("计算会员2的折扣信息");
    }
}
