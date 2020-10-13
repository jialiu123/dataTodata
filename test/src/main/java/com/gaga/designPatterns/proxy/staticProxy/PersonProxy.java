package com.gaga.designPatterns.proxy.staticProxy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:15
 * @version: 1.0
 */
public class PersonProxy {

    private Person person;

    public PersonProxy(Person person) {
        this.person = person;
    }

    public void play() {
        person.play();
    }
}
