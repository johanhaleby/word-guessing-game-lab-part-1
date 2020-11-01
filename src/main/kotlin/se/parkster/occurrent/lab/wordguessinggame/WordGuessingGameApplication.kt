package se.parkster.occurrent.lab.wordguessinggame

import org.occurrent.application.converter.CloudEventConverter
import org.occurrent.application.service.blocking.ApplicationService
import org.occurrent.application.service.blocking.implementation.GenericApplicationService
import org.occurrent.eventstore.api.blocking.EventStore
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import se.parkster.occurrent.lab.wordguessinggame.domain.DomainEvent

@SpringBootApplication
class WordGuessingGameApplication {

    @Bean
    fun cloudEventConverter(): CloudEventConverter<DomainEvent> = TODO()

    @Bean
    fun eventStore(): EventStore = TODO()

    @Bean
    fun applicationService(eventStore: EventStore, cloudEventConverter: CloudEventConverter<DomainEvent>): ApplicationService<DomainEvent> =
            GenericApplicationService(eventStore, cloudEventConverter)
}

fun main(args: Array<String>) {
    runApplication<WordGuessingGameApplication>(*args)
}
