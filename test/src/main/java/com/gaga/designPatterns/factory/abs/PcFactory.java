package com.gaga.designPatterns.factory.abs;

import com.gaga.designPatterns.factory.MacPc;
import com.gaga.designPatterns.factory.Mouse;
import com.gaga.designPatterns.factory.Pc;
import com.gaga.designPatterns.factory.WindowPc;

/**
 * @author ：liujia
 * @date ：Created in 2020/10/23 10:24
 * @description：TODO
 * @version: 1.0
 */
public class PcFactory extends Factory {

    @Override
    public Mouse createMouse(int type) {
        return null;
    }

    @Override
    public Pc createPc(int type) {
        if (type == 1) {
            return new MacPc();
        } else if (type == 2) {
            return new WindowPc();
        }
        return null;
    }
}
