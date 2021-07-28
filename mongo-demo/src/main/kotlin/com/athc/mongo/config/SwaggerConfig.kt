package com.athc.mongo.config

import com.spring4all.swagger.EnableSwagger2Doc
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
@EnableSwagger2Doc
open class SwaggerConfig {

  @Bean(value = ["defaultApi2"])
  open fun defaultApi2(): Docket {
    return Docket(DocumentationType.SWAGGER_2)
        .apiInfo(ApiInfoBuilder() //.title("swagger-bootstrap-ui-demo RESTful APIs")
            .version("1.0")
            .build()) //分组名称
        .groupName("2.X版本")
        .select() //这里指定Controller扫描包路径
        .apis(RequestHandlerSelectors.basePackage("com.athc.mongo.controller"))
        .paths(PathSelectors.any())
        .build()
  }
}