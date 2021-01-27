1、jps 找到java进程
2、jmap 堆内存的快照信息
jmap -heap 76 查看76进行的堆内存快照
jmap -dump:format=b,live,file=1.bin 76 生成76进行的堆内存快照文件
3、jconsole 查看完整的一些java进行信息
4、jvisualvm 也是一个工具
5、mat,主要对内存泄漏进行一些分析
