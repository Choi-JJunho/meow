package meow.meow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MeowApplication

fun main(args: Array<String>) {
    runApplication<MeowApplication>(*args)
}
