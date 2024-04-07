package com.gdelis.events.repository;

import com.gdelis.events.domain.EventDetails;
import reactor.core.publisher.Flux;

public interface EventsRepository {
   Flux<EventDetails> findAll();
}
