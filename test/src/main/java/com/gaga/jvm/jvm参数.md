
https://www.cnblogs.com/hongdada/p/10277782.html

-XX:+<option> 启用option，例如：-XX:+PrintGCDetails启动打印GC信息的选项，其中+号表示true，开启的意思
-XX:-<option> 不启用option，例如：-XX:-PrintGCDetails关闭启动打印GC信息的选项，其中-号表示false，关闭的意思
-XX:<option>=<number> 设定option的值为数字类型，可跟单位，例如 32k, 1024m, 2g。例如：-XX:MaxPermSize=64m
-XX:<option>=<string> 设定option的值为字符串，例如： -XX:HeapDumpPath="C:\Users\Daxin\Desktop\jvmgcin"

1、查看JVM参数信息
java -XX:+PrintCommandLineFlags -version
2、查看堆内存信息
java -XX:+PrintGCDetails -version
3、设置调用类打印详细信息
-XX:+PrintGCDetails -verbose:gc

-Xss 栈内存大小

-XX:MetaspaceSize=512m 元空间初始化大小
-XX:MaxMetaspaceSize=512m 元空间最大大小

-Xms 堆内存初始化大小
-Xmx 堆内存最大大小
-Xmn 年轻代大小
-XX:NewRatio 年轻代与年老代的比值 默认 8 意思就是 年轻代 2 老年代 8
-XX:SurvivorRatio  Eden区与Survivor区的大小比值 默认8:1:1 Eden 8 2个交换区各占用1
-XX:MaxTenuringThreshold=0 设置垃圾最大年龄。如果设置为0的话，则年轻代对象不经过Survivor区，直接进入年老代。

-XX:+DisableExplicitGC  忽略手动调用GC, System.gc()的调用就会变成一个空调用，完全不触发GC
-verbose:gc 显示每个GC详情


Xms与Xmx配置相同的值，为了能够在GC后不需要重新分隔计算堆区的大小而浪费资源。