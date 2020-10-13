package com.gaga.designPatterns.strategy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/12 10:44
 * @description：策略模式,感觉策略的确和静态代理很像
 * @version: 1.0
 */
public class StrategyTest {

    public static void main(String[] args) {

        MemberStrategyContext memberStrategyContext = new MemberStrategyContext(new LevelOneStrategy());
        memberStrategyContext.calcPrice(12.00);

    }

}
