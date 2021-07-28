package com.athc.common.constant

enum class ErrorCode(private val code: String, private val message: String) {

    ERROR("10000", "系统错误"),
    FOO_NOT_FOUND("10001", "Foo 未找到")
    ;

    fun code(): String = code

    fun message(): String = message

}