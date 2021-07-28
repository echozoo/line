package com.athc.kill.service

import java.math.BigDecimal

/**
 * @author jjj
 * @date 2020/9/16
 * @since JDK1.8
 */
interface OrderService {

  /**
   * 下单
   *
   */
  fun createOrder(goodsId: Long, quantity: BigDecimal): Boolean

}