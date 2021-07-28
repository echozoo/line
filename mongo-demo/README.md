# mongoDb 使用demo

mongoDb 4.0 版本开始支持事务

```kotlin
class MongoConfig{
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
```
