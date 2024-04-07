package com.gdelis.events.service;

import com.gdelis.events.domain.EventDetails;
import com.gdelis.events.repository.EventsRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EventsService {

   private final EventsRepository eventsRepository;

   public EventsService(final EventsRepository eventsRepository) {
      this.eventsRepository = eventsRepository;
   }

   public Flux<EventDetails> getEvents() {
      return eventsRepository.findAll();
   }
}
