package com.gdelis.events.repository;

import com.gdelis.events.dao.EventDetailsDAO;
import com.gdelis.events.domain.EventDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresEventsRepository implements EventsRepository {

   private final List<EventDetailsDAO> eventDetailsList;

   public PostgresEventsRepository() {
      this.eventDetailsList = new ArrayList<>();

      this.eventDetailsList.add(new EventDetailsDAO(1, "event-title-1", null, null));
      this.eventDetailsList.add(new EventDetailsDAO(2, "event-title-2", null, null));
   }

   public List<EventDetails> findAll() {
      return eventDetailsList.stream()
                             .map(EventDetails::from)
                             .toList();
   }

   @Override
   public EventDetails findById(final Integer eventId) {
      return eventDetailsList.stream()
                             .filter(s -> Objects.equals(s.id(), eventId))
                             .map(EventDetails::from)
                             .findAny()
                             .orElseThrow(
                                 () -> new RuntimeException(String.format("event with id: %s not found", eventId)));
   }

   @Override
   public void deleteById(final Integer eventId) {
      eventDetailsList.stream()
                      .filter(s -> Objects.equals(s.id(), eventId))
                      .findAny()
                      .ifPresent(eventDetailsList::remove);
   }
}
