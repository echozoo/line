package com.athc.common.exception

import com.athc.common.constant.ErrorCode

class BizException(
    override val error: ErrorCode,
    override val message: String? = error.message(),
    override val cause: Throwable? = null
) : BaseException(error, message, cause) {


}