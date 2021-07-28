package com.athc.kill

import com.athc.kill.service.OrderService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.math.BigDecimal

open class KillApplicationTests(
    @Autowired
    private val orderService: OrderService
) : BaseTest() {

  @Test
  fun test() {
    orderService.createOrder(2, BigDecimal.ONE)
  }

}
