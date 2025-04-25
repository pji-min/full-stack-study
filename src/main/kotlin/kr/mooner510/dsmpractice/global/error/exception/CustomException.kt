package kr.mooner510.dsmpractice.global.error.exception

open class CustomException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)