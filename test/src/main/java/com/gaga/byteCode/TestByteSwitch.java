package com.gaga.byteCode;

/**
 * @author ：liujia
 * @date ：Created in 2021/1/28 20:43
 * @description：TODO
 * @version: 1.0
 */
public class TestByteSwitch {

    public static void main(String[] args) {
        test2();
    }


    public static void test1() {
        String str = "hello";

        switch (str) {
            case "hello":
                System.out.println("h");
                break;
            case "world":
                System.out.println("w");
                break;
        }
    }

    public static void test2() {

        PersonType personType = PersonType.MAN;
        switch (personType) {
            case MAN:
                System.out.println("男人");
                break;
            case WOMAN:
                System.out.println("女人");
                break;
        }

    }


}
