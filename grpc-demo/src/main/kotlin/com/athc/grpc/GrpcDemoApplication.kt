package com.athc.grpc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author dujf
 */
@SpringBootApplication(scanBasePackages = ["com.athc.grpc"])
open class GrpcDemoApplication

fun main(args: Array<String>) {
  SpringApplication.run(GrpcDemoApplication::class.java, *args)
}
