package se.parkster.occurrent.lab.wordguessinggame.application

import io.cloudevents.CloudEvent
import org.occurrent.eventstore.api.blocking.EventStore
import org.occurrent.eventstore.api.blocking.EventStream
import se.parkster.occurrent.lab.wordguessinggame.domain.DomainEvent
import kotlin.streams.asSequence
import kotlin.streams.asStream

class ApplicationService constructor(private val eventStore: EventStore,
                                     private val cloudEventConverter: CloudEventConverter) {

    fun execute(streamId: String, functionThatCallsDomainModel: (Sequence<DomainEvent>) -> Sequence<DomainEvent>) {
        // Read all events from the event store for a particular stream
        val eventStream: EventStream<CloudEvent> = eventStore.read(streamId)
        // Convert the cloud events into domain events
        val domainEventsInStream: Sequence<DomainEvent> = eventStream.events().map(cloudEventConverter::toDomainEvent).asSequence()

        // Call a pure function from the domain model which returns a sequence of domain events
        val newDomainEvents = functionThatCallsDomainModel(domainEventsInStream)

        // Convert domain events to cloud events and write them to the event store
        eventStore.write(streamId, eventStream.version(), newDomainEvents.map(cloudEventConverter::toCloudEvent).asStream())
    }
}
