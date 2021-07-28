package com.athc.mybatis.config

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import com.spring4all.swagger.EnableSwagger2Doc
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


/**
 * @author jjj
 * @date 2020/9/16
 * @since JDK1.8
 */
@MapperScan(
    "com.athc.mybatis.mapper"
)
@ComponentScan("com.athc.mybatis")
@Configuration
@EnableSwagger2Doc
open class MybatisConfig {

  /**
   * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置
   * MybatisConfiguration#useDeprecatedExecutor = false
   * 避免缓存出现问题(该属性会在旧插件移除后一同移除)
   */
  @Bean
  open fun mybatisPlusInterceptor(): MybatisPlusInterceptor? {
    val interceptor = MybatisPlusInterceptor()
    interceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))
    return interceptor
  }
}