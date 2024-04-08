package com.gdelis.events.repository;

import com.gdelis.events.domain.EventDetails;
import com.gdelis.events.dao.EventDetailsDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PostgresEventsRepository implements EventsRepository {

   private final List<EventDetailsDAO> eventDetailsList;

   public PostgresEventsRepository() {
      this.eventDetailsList = new ArrayList<>();

      this.eventDetailsList.add(EventDetailsDAO.builder()
                                               .id("1")
                                               .title("event-title-1")
                                               .build());
      this.eventDetailsList.add(EventDetailsDAO.builder()
                                               .id("2")
                                               .title("event-title-2")
                                               .build());
   }

   public Flux<EventDetails> findAll() {
      return Flux.fromIterable(eventDetailsList)
                 .map(EventDetails::from);
   }

   @Override
   public Mono<EventDetails> findById(final String eventId) {
      return Flux.fromIterable(eventDetailsList)
                 .filter(s -> eventId.equals(s.id()))
                 .next()
                 .map(EventDetails::from);
   }
}
