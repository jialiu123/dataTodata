package com.gaga.jvm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * 元空间溢出演示 java.lang.OutOfMemoryError: Metaspace
 * 动态代理的底层原理 使用的就是ClassWriter
 * <p>
 * 元空间1.8以后基本上不会存在溢出的情况，目前直接使用的是直接内容，所以溢出可能性几乎为0
 * 方法区是JVM中的一个概念，而元空间和永久代是方法区的具体实现
 * 1.8以前 永久代使用的堆内存，这样就有很大的可能性有造成溢出情况
 * 1.8以后 去除了永久代 新增元空间
 * 但是需要注意的是 对于StringTable字符串常量池 还在堆内存中
 * <p>
 * 为什么StringTable放在堆内存中，因为增加回收效率，如果放在元空间中，回收效率将会很低
 * 元空间只有FullGc的时候才能进行垃圾回收
 *
 * <p>
 * 配置参数 -XX:MetaspaceSize=3m -XX:MaxMetaspaceSize=30m
 *
 * @author ：liujia
 * @date ：Created in 2021/1/26 9:02
 * @version: 1.0
 */
public class PermOutTest extends ClassLoader {

    public static List<Class<?>> createClasses() {
        // 类持有
        List<Class<?>> classes = new ArrayList<Class<?>>();
        // 循环1000w次生成1000w个不同的类。
        for (int i = 0; i < 10000; ++i) {
            ClassWriter cw = new ClassWriter(0);
            // 定义一个类名称为Class{i}，它的访问域为public，父类为java.lang.Object，不实现任何接口
            cw.visit(Opcodes.V1_1, Opcodes.ACC_PUBLIC, "Class" + i, null,
                    "java/lang/Object", null);
            // 定义构造函数<init>方法
            MethodVisitor mw = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>",
                    "()V", null, null);
            // 第一个指令为加载this
            mw.visitVarInsn(Opcodes.ALOAD, 0);
            // 第二个指令为调用父类Object的构造函数
            mw.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object",
                    "<init>", "()V");
            // 第三条指令为return
            mw.visitInsn(Opcodes.RETURN);
            mw.visitMaxs(1, 1);
            mw.visitEnd();
            PermOutTest test = new PermOutTest();
            byte[] code = cw.toByteArray();
            // 定义类
            Class<?> exampleClass = test.defineClass("Class" + i, code, 0, code.length);
            classes.add(exampleClass);
        }
        return classes;
    }

    public static void main(String[] args) {
        createClasses();
    }


}

