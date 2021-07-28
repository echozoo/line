# 并发控制

## synchronized关键字
* 实现原理？
  基于jvm实现


## lock接口
* 实现原理？
  通过AQS算法实现
     
## FAQ
* spring 事务管理中的synchronized和lock为什么失效？
事务还未提交，下一个线程进入读取了脏数据，解决这个问题需要将整个事务锁住