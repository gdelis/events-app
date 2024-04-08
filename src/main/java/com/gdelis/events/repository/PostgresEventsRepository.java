package com.gdelis.events.repository;

import com.gdelis.events.dao.EventDetailsDAO;
import com.gdelis.events.domain.EventDetails;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

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

   public List<EventDetails> findAll() {
      return eventDetailsList.stream()
                             .map(EventDetails::from)
                             .toList();
   }

   @Override
   public EventDetails findById(final String eventId) {
      return eventDetailsList.stream()
                             .filter(s -> eventId.equals(s.id()))
                             .map(EventDetails::from)
                             .findAny()
                             .orElseThrow(
                                 () -> new RuntimeException(String.format("event with id: %s not found", eventId)));
   }

   @Override
   public void deleteById(final String eventId) {
      eventDetailsList.stream()
                      .filter(s -> eventId.equals(s.id()))
                      .findAny()
                      .ifPresent(eventDetailsList::remove);
   }
}
