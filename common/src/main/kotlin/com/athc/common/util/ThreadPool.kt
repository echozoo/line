package com.athc.common.util

import java.util.concurrent.*

/**
 * @author jjj
 * @date 2020/9/2
 * @since JDK1.8
 */
object ThreadPool {

  fun executor(
      corePoolSize: Int = DEFAULT_CORE_POOL_SIZE,
      maxPoolSize: Int = DEFAULT_MAX_POOL_SIZE,
      keepAliveTime: Long = DEFAULT_KEEP_ALIVE_TIME,
      timeUnit: TimeUnit = TimeUnit.SECONDS,
      capacity: Int = DEFAULT_CAPACITY,
      threadFactory: ThreadFactory = Executors.defaultThreadFactory(),
      handler: RejectedExecutionHandler = ThreadPoolExecutor.AbortPolicy()
  ): ThreadPoolExecutor = ThreadPoolExecutor(
      corePoolSize,
      maxPoolSize,
      keepAliveTime,
      timeUnit,
      LinkedBlockingQueue(capacity),
      threadFactory,
      handler
  )

  fun scheduledExecutor(
      corePoolSize: Int = DEFAULT_CORE_POOL_SIZE,
      threadFactory: ThreadFactory = Executors.defaultThreadFactory(),
      handler: RejectedExecutionHandler = ThreadPoolExecutor.AbortPolicy()
  ): ScheduledThreadPoolExecutor = ScheduledThreadPoolExecutor(
      corePoolSize,
      threadFactory,
      handler
  )


  private const val DEFAULT_CORE_POOL_SIZE: Int = 5
  private const val DEFAULT_MAX_POOL_SIZE: Int = 20
  private const val DEFAULT_KEEP_ALIVE_TIME: Long = 1L
  private const val DEFAULT_CAPACITY: Int = 100
}