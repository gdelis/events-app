package com.gdelis.events.service;

import com.gdelis.events.domain.EventDetails;
import com.gdelis.events.repository.EventsRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventsService {

   private final EventsRepository eventsRepository;

   public EventsService(final EventsRepository eventsRepository) {
      this.eventsRepository = eventsRepository;
   }

   public Flux<EventDetails> getEvents() {
      return eventsRepository.findAll();
   }

   public Mono<EventDetails> getEventById(final String eventId) {
      return eventsRepository.findById(eventId);
   }

   public void deleteEventById(final String eventId) {
      eventsRepository.deleteById(eventId);
   }
}
