package com.athc.mybatis

import com.athc.mybatis.config.MybatisConfig
import com.athc.mybatis.mapper.GoodsMapper
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * @author jjj
 * @date 2020/9/16
 * @since JDK1.8
 */
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [MybatisConfig::class])
@MybatisTest
open class MapperTest(
    @Autowired
    private val mapper: GoodsMapper
) {

  @Test
  fun testMapper() {
    mapper.selectList(QueryWrapper()).let {
      Assertions.assertTrue(it.isEmpty())
    }
  }
}