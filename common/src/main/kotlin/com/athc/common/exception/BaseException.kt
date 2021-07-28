package com.athc.common.exception

import com.athc.common.constant.ErrorCode
import java.lang.RuntimeException

/**
 * @author jjj
 * @date 2020/8/25
 * @since JDK1.8
 */
open class BaseException(
    open val error: ErrorCode, override val message: String?, override val cause: Throwable?
) : RuntimeException(message, cause)