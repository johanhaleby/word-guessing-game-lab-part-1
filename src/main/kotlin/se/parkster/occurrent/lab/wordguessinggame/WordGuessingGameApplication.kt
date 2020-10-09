package se.parkster.occurrent.lab.wordguessinggame

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WordGuessingGameApplication

fun main(args: Array<String>) {
    runApplication<WordGuessingGameApplication>(*args)
}
