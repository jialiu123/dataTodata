package com.gaga.designPatterns.factory.abs;

import com.gaga.designPatterns.factory.Mouse;
import com.gaga.designPatterns.factory.Mouse1;
import com.gaga.designPatterns.factory.Mouse2;
import com.gaga.designPatterns.factory.Pc;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:07
 * @description：TODO
 * @version: 1.0
 */
public class MouseFactory extends Factory {

    @Override
    public Mouse createMouse(int type) {
        if (type == 1) {
            return new Mouse1();
        } else if (type == 2) {
            return new Mouse2();
        }
        return null;
    }

    @Override
    public Pc createPc(int type) {
        return null;
    }
}
