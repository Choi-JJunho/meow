package pomonyang.pomonyang.global.exception

data class InvalidArgsErrorDetails(
    val violations: List<String>,
    override val errorTraceId: String,
    override val message: String,
    override val detail: String? = null
) : ErrorDetails
