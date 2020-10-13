package com.gaga.designPatterns.strategy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 10:54
 * @version: 1.0
 */
public class LevelOneStrategy implements MemberStrategy {
    @Override
    public void calcPrice(double booksPrice) {
        System.out.println("计算会员1的折扣信息");
    }
}
