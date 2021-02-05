package com.gaga.threads.ProducerAndConsumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 消息类
 *
 * @author ：liujia
 * @date ：Created in 2021/2/5 14:25
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
@ToString
public class Message {

    private Object content;

}
