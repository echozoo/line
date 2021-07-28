package com.athc.common.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * @author jjj
 * @date 2020/8/20
 * @since JDK1.8
 */

val Any.logger: Logger
  get() = LoggerFactory.getLogger(this.javaClass)

fun <T> Any.toT(clazz: Class<T>): T {
  return jacksonObjectMapper().let { mapper ->
    mapper.writeValueAsString(this).let {
      mapper.readValue(it, clazz)
    }
  }
}

fun Any.anyToMap(): Map<String, Any?> {
  return this.toT(Map::class.java) as Map<String, Any?>
}

fun Any.queryString(): String {
  return this.anyToMap()
      .filter { null != it.value }
      .map { "${it.key}=${it.value}" }
      .joinToString("&")
}

