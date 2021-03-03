package com.gaga;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ：liujia
 * @date ：Created in 2021/3/2 14:19
 * @version: 1.0
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
//        LocalDateTime localDateTime = new LocalDateTime(new LocalDate(),new LocalTime());

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    }

}
