#说明配置
#参考文档：http://www.redis.cn/documentation.html
1.redis.conf修改：
  bind ip,指定可以访问的IP
2.数据目录：
dir
3.配置为缓存服务器（相当于memcached)
  指定可用的最大内存（超出后删除）
  maxmemory 2mb
  缓存清理策略
  maxmemory-policy allkeys-lru

4.常用命令(http://www.redis.cn/commands.html#)
 1).停止服务
   shutdown [nosave/save]
 2).清空所有数据库
   FLUSHALL
 3).清空当前数据库
   FLUSHDB
 4).返回当前数据库的keys数量
   DBSIZE 
 5).关闭客户端链接
   CLIENT KILL ip:port
 6).请求服务器关闭连接。连接将会尽可能快的将未完成的客户端请求完成处理。
   QUIT
 7).选择一个数据库，下标值从0开始，一个新连接默认连接的数据库是DB0。
   SELECT index

5.Redis启动
1).src/redis-server或者src/redis-server redis.conf
   src/redis-server redis.conf 1>log.log 2>errlog.log
   1为标准输出，2为错误输出
2).将 Redis 作为 Linux 服务随机启动
   vi /etc/rc.local, 加入代码：
   /root/install/redis-2.4.9/src/redis-server
3).客户端连接
   src/redis-cli
4).停止redis服务：
   src/redis-cli shutdown

=============Redis 安装提示================
Redis安装提示
我们建议使用linux部署Redis。Redis也在osx，FreeBSD，OpenBSD上经过测试，但Linux经过所有主要的压力测试，并且最多产品部署。
确保设置Linux内核overcommit memory setting为1。向/etc/sysctl.conf添加vm.overcommit_memory = 1然后重启，或者运行命令sysctl vm.overcommit_memory=1以便立即生效。
确保禁用Linux内核特性transparent huge pages，它对内存使用和延迟有非常大的负面影响。通过命令echo never > sys/kernel/mm/transparent_hugepage/enabled来完成。
确保你的系统设置了一些swap（我们建议和内存一样大）。如果linux没有swap并且你的redis实例突然消耗了太多内存，或者Redis由于内存溢出会当掉，或者Linux内核OOM Killer会杀掉Redis进程。
设置一个明确的maxmemory参数来限制你的实例，以便确保实例会报告错误而不是当接近系统内存限制时失败
如果你对一个写频繁的应用使用redis，当向磁盘保存RDB文件或者改写AOF日志时，redis可能会用正常使用内存2倍的内存。额外使用的内存和保存期间写修改的内存页数量成比例，因此经常和这期间改动的键的数量成比例。确保相应的设置内存的大小。
当在daemontools下运行时，使用daemonize no
即使你禁用持久化，如果你使用复制，redis会执行rdb保存，除非你使用新的无磁盘复制特性，这个特性目前还是实验性的。
如果你使用复制，确保要么你的master激活了持久化，要么它不会在当掉后自动重启。slave是master的完整备份，因此如果master通过一个空数据集重启，slave也会被清掉。
