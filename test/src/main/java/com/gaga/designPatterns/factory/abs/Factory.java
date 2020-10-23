package com.gaga.designPatterns.factory.abs;

import com.gaga.designPatterns.factory.Mouse;
import com.gaga.designPatterns.factory.Pc;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:09
 * @description：TODO
 * @version: 1.0
 */
public abstract class Factory {

    public abstract Mouse createMouse(int type);

    public abstract Pc createPc(int type);
}
