package com.lynch.config;

public class PersonService {
    private ExampleServiceProperties properties;

    public PersonService() {
    }

    public PersonService(ExampleServiceProperties properties) {
        this.properties = properties;
        String message = String.format("大家好，我叫: %s, 今年 %s岁, 性别: %s",
                properties.getName(), properties.getAge(), properties.getSex());
        System.out.println(message);
    }

    public void sayHello() {
        String message = String.format("大家好，我叫: %s, 今年 %s岁, 性别: %s",
                properties.getName(), properties.getAge(), properties.getSex());
        System.out.println(message);
    }
}