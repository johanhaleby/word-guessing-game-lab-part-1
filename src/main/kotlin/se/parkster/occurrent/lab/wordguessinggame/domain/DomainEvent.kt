package se.parkster.occurrent.lab.wordguessinggame.domain

import java.time.LocalDateTime
import java.util.*

sealed class DomainEvent {
    abstract val eventId: UUID
    abstract val timestamp: LocalDateTime
    abstract val gameId: UUID
    open val type: String = this::class.simpleName!!
}