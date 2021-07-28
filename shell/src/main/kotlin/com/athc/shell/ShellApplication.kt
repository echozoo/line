package com.athc.shell

import com.athc.common.util.logger
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ShellApplication

fun main(args: Array<String>) {
  SpringApplication.run(ShellApplication::class.java, *args).let {
    it.logger.info("""
    http://localhost:8002/swagger-ui.html
  """.trimIndent())
  }
}