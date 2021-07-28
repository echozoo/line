package com.athc.kill.service

import com.athc.common.constant.ErrorCode
import com.athc.common.exception.BizException
import com.athc.common.util.logger
import com.athc.mybatis.entity.GoodsOrder
import com.athc.mybatis.mapper.GoodsMapper
import com.athc.mybatis.mapper.GoodsOrderMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate
import java.math.BigDecimal
import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

@Service
open class OrderServiceImpl(
    private val goodsMapper: GoodsMapper,
    private val goodsOrderMapper: GoodsOrderMapper,
    private val transactionTemplate: TransactionTemplate
) : OrderService {

  private val lock: Lock = ReentrantLock(true)

  /**
   * 下单
   * spring 事务中的lock会失效？
   */

  override fun createOrder(goodsId: Long, quantity: BigDecimal): Boolean {
    lock.lock()
    try {
      val res = transactionTemplate.execute {
        val goods = goodsMapper.selectById(goodsId)
            ?: throw BizException(ErrorCode.FOO_NOT_FOUND, "商品未找到")
        if (null == goods.amount || (goods.amount ?: BigDecimal.ZERO).compareTo(quantity) < 0) {
          logger.warn("库存不足,amount=${goods.amount}")
          return@execute
        }

        val rest = goods.amount!!.subtract(quantity)
        val res = goodsMapper.updateById(goods.apply {
          amount = rest
        })
        if (res <= 0) {
          logger.warn("更新库存失败，goodId=$goodsId")
          return@execute
        }
        goodsOrderMapper.insert(GoodsOrder().apply {
          this.goodsId = goodsId
          orderId = UUID.randomUUID().toString().replace("-", "")
        })
        logger.info("下单成功，库存剩余：$rest")
      } ?: false
      return true
    } finally {
      lock.unlock()
    }
  }
}