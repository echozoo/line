package com.athc.shell

import com.athc.kill.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal


/**
 * @author jjj
 * @date 2020/9/16
 * @since JDK1.8
 */
@RestController
@RequestMapping()
class TestController(
    private val orderService: OrderService
) {

  @GetMapping("/test")
  fun test(): String {
    orderService.createOrder(goodsId = 2L, quantity = BigDecimal.ONE)
    return ""
  }
}