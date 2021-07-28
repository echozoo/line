
![](https://img.shields.io/badge/hippo-V1.1.0-brightgreen)

# postgresql-spring-boot-mybatis-plus
postgresql 数据库使用mybatis-plus 

## 添加依赖

<!-- mybatis的orm插件 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatisplus-spring-boot-starter</artifactId>
            <version>1.0.5</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus</artifactId>
            <version>2.3</version>
        </dependency>
        <!--mybatis-plus-->
        <!--逆向工程需要-->
        <dependency>
            <groupId>org.apache.velocity</groupId>
            <artifactId>velocity</artifactId>
            <version>1.7</version>
        </dependency>
        <!--druid-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.25</version>
        </dependency>
        <!--druid-->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
        </dependency>
         <!--druid依赖log4j-->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
 ## 配置文件
 
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.url=jdbc:postgresql://ip:port/db
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
#配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙


#连接池的配置信息
spring.datasource.initialSize=5
spring.datasource.minIdle=5
spring.datasource.maxActive=20
spring.datasource.maxWait=60000
spring.datasource.timeBetweenEvictionRunsMillis=60000
spring.datasource.minEvictableIdleTimeMillis=300000
spring.datasource.validationQuery=SELECT 1 FROM DUAL
spring.datasource.testWhileIdle=true
spring.datasource.testOnBorrow=false
spring.datasource.testOnReturn=false
spring.datasource.poolPreparedStatements=true
spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
spring.datasource.filters=stat,wall,log4j
spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000

 mybatis-plus.mapper-locations=classpath:/mapper/*Mapper.xml
 `注意model文件夹配置，错了回导致生成model出错`
mybatis-plus.typeAliasesPackage=com.gitee.web.model


### 注意事项
1. 设置数据源类型时修改 数据库类型
        `// 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.POSTGRE_SQL);`
2. 使用分叶插件时需要修改拦截的数据库类型,postgresql分页与mysql有一点差别，limit 1 offset 1
  ```java
  /**
     * mybatis-plus 分页插件
     */

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
       `page.setDialectType("postgresql");`
        return page;
    }
 ```
