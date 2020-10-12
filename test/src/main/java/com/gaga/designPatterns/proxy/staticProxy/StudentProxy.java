package com.gaga.designPatterns.proxy.staticProxy;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/10 17:15
 * @version: 1.0
 */
public class StudentProxy {

    private Student student;

    public StudentProxy(Student student) {
        this.student = student;
    }

    public void play() {
        student.play();
    }
}
