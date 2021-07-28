package com.athc.mongo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author dujf
 */
@SpringBootApplication(scanBasePackages = ["com.athc.mongo"])
open class MongoDemoApplication

fun main(args: Array<String>) {
  SpringApplication.run(MongoDemoApplication::class.java, *args)
}
