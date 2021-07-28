package com.athc.mongo.controller

import com.athc.common.util.logger
import com.athc.common.constant.ErrorCode
import com.athc.common.exception.BizException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ControllerAdvice {

  @ExceptionHandler(value = [BizException::class])
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  fun handlerBizException(request: HttpServletRequest, e: BizException): Pair<String, String> {
    logger.error("error message:{}", e.localizedMessage, e)
    return Pair(e.error.code(), e.localizedMessage)

  }

  @ExceptionHandler(value = [Exception::class])
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  fun handlerException(request: HttpServletRequest, e: Exception): Pair<String, String> {
    logger.error("system error message:{}", e.localizedMessage, e)
    return Pair(ErrorCode.ERROR.code(), e.localizedMessage)
  }
}