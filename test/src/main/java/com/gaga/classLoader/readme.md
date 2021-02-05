https://blog.csdn.net/ns_code/article/details/17881581

类从被加载到虚拟机内存中开始，到卸载出内存为止，
它的整个生命周期包括：
加载、验证、准备、解析、初始化、使用和卸载七个阶段。

其中类加载的过程包括了
加载、验证、准备、解析、初始化五个阶段。
在这五个阶段中，加载、验证、准备和初始化这四个阶段发生的顺序是确定的，
而解析阶段则不一定，它在某些情况下可以在初始化阶段之后开始，这是为了支持Java语言的运行时绑定（也成为动态绑定或晚期绑定）

启动类加载器：Bootstrap ClassLoader，跟上面相同。它负责加载存放在JDK\jre\lib(JDK代表JDK的安装目录，下同)下，或被-Xbootclasspath参数指定的路径中的，并且能被虚拟机识别的类库（如rt.jar，所有的java.*开头的类均被Bootstrap ClassLoader加载）。启动类加载器是无法被Java程序直接引用的。
扩展类加载器：Extension ClassLoader，该加载器由sun.misc.Launcher$ExtClassLoader实现，它负责加载JDK\jre\lib\ext目录中，或者由java.ext.dirs系统变量指定的路径中的所有类库（如javax.*开头的类），开发者可以直接使用扩展类加载器。
应用程序类加载器：Application ClassLoader，该类加载器由sun.misc.Launcher$AppClassLoader来实现，它负责加载用户类路径（ClassPath）所指定的类，开发者可以直接使用该类加载器，如果应用程序中没有自定义过自己的类加载器，一般情况下这个就是程序中默认的类加载器。

双亲委派机制：
一直往上找可加载过，都没有加载过，那就自己加载，这个地方使用递归的方式实现，存在一个很巧妙的方法，如果父类加载成功，直接抛出异常，退出当前递归
具体代码参考ClassLoader中的loadClass方法

问题：
如何打破双亲委派机制