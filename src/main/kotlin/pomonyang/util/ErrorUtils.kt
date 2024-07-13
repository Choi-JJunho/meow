package pomonyang.util

import java.util.*

object ErrorUtils

fun ErrorUtils.createErrorTraceId() = UUID.randomUUID().toString()
