package com.gdelis.events.repository;

import com.gdelis.events.domain.EventDetails;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventsRepository {
   Flux<EventDetails> findAll();

   Mono<EventDetails> findById(String eventId);
}
