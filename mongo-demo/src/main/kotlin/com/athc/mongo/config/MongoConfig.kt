package com.athc.mongo.config

import com.athc.common.util.logger
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.convert.CustomConversions
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.convert.DbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext


@Configuration
@EnableMongoAuditing
open class MongoConfig {

  /**
   * 支持事务
   */
  @Bean
  open fun transactionManager(dbFactory: MongoDbFactory): MongoTransactionManager {
    return MongoTransactionManager(dbFactory)
  }

  /**
   * 去除class字段
   */
  @Bean
  open fun mappingMongoConverter(factory: MongoDbFactory, context: MongoMappingContext, beanFactory: BeanFactory): MappingMongoConverter {
    val dbRefResolver: DbRefResolver = DefaultDbRefResolver(factory)
    val mappingConverter = MappingMongoConverter(dbRefResolver, context)
    try {
      mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions::class.java))
    } catch (e: NoSuchBeanDefinitionException) {
      logger.info("error create class convert:{}", e.localizedMessage, e)
    }
    mappingConverter.typeMapper = DefaultMongoTypeMapper(null)
    return mappingConverter
  }
}