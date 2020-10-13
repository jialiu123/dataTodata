package com.gaga.designPatterns.decorator;

/**
 * 定义：
 * 装饰模式是在不必改变原类文件和使用继承的情况下，
 * 动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
 * 个人理解：不修改对象，不用继承，在此基础上进行个性化的定制，组合。
 * 有可能不仅仅是为了增强，也有可能是为了削弱
 *
 * @author ：liujia
 * @date ：Created in 2020/10/12 13:07
 * @description：装饰器模式测试
 * @version: 1.0
 */
public class DecoratorTest {

    public static void main(String[] args) {
        GirlDecorator girlDecorator = new GirlDecorator(new Girl());
        girlDecorator.say();
    }

}
