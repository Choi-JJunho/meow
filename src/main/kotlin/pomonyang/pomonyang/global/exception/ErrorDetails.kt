package pomonyang.pomonyang.global.exception

interface ErrorDetails {
    val message: String
    val detail: String?
    val errorTraceId: String
}
