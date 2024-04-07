package com.gdelis.events.repository;

import com.gdelis.events.domain.EventDetails;
import com.gdelis.events.dto.EventDetailsDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class PostgresEventsRepository implements EventsRepository {

   private final List<EventDetailsDTO> eventDetailsList;

   public PostgresEventsRepository() {
      this.eventDetailsList = new ArrayList<>();

      this.eventDetailsList.add(EventDetailsDTO.builder()
                                            .id("1")
                                            .title("event-title-1")
                                            .build());
      this.eventDetailsList.add(EventDetailsDTO.builder()
                                            .id("2")
                                            .title("event-title-2")
                                            .build());
   }

   public Flux<EventDetails> findAll() {
      return Flux.fromIterable(eventDetailsList)
          .map(EventDetailsDTO::from);
   }
}
