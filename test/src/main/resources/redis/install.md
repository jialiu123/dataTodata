https://blog.csdn.net/smartsteps/article/details/103678263/

docker run --name redis -p 6379:6379 redis:latest --requirepass redis

密码：redis


配置文件方式启动：
https://www.cnblogs.com/934827624-qq-com/p/10175478.html

docker run -p 6379:6379 --name redis -v /home/redis/redis.conf:/etc/redis/redis.conf -v /home/redis/data:/data -d redis redis-server /etc/redis/redis.conf 

进入docker环境
docker exec -it feed158eab19  /bin/bash