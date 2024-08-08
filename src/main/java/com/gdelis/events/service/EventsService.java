package com.gdelis.events.service;

import com.gdelis.events.domain.EventDetails;
import com.gdelis.events.repository.EventsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EventsService {

   private final EventsRepository eventsRepository;

   public EventsService(final EventsRepository eventsRepository) {
      this.eventsRepository = eventsRepository;
   }

   public List<EventDetails> getEvents() {
      return eventsRepository.findAll();
   }

   public Optional<EventDetails> getEventById(final Integer eventId) {
      return Optional.of(eventsRepository.findById(eventId));
   }
}
