package se.parkster.occurrent.lab.wordguessinggame.application

import io.cloudevents.CloudEvent
import se.parkster.occurrent.lab.wordguessinggame.domain.DomainEvent


interface CloudEventConverter {
    fun toCloudEvent(domainEvent: DomainEvent) : CloudEvent
    fun toDomainEvent(cloudEvent: CloudEvent) : DomainEvent
}