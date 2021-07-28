package com.athc.common

import com.athc.common.util.ThreadPool
import org.junit.jupiter.api.Test

/**
 * @author jjj
 * @date 2020/9/2
 * @since JDK1.8
 */
class ThreadPoolTest {

  @Test
  fun test() {
    val executor1 = ThreadPool.executor()
    repeat(50) {
      executor1.execute {
        println(Thread.currentThread().name + ":开始执行程序！！！")
        Thread.sleep(1000L)
        println("总线程数1：${Thread.activeCount()}")
        println(Thread.currentThread().name + ":结束执行程序！！！")
      }
    }

    repeat(50) {
      executor1.execute {
        println(Thread.currentThread().name + ":开始执行程序！！！")
        Thread.sleep(1000L)
        println("总线程数2：${Thread.activeCount()}")
        println(Thread.currentThread().name + ":结束执行程序！！！")
      }
    }
    Thread.sleep(10000)
  }
}