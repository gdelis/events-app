package com.gdelis.events;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EventsService {

   private final List<EventDetails> eventDetailsList;

   public EventsService() {
      this.eventDetailsList = new ArrayList<>();
      this.eventDetailsList.add(EventDetails.builder()
                                            .id("1")
                                            .title("event-title-1")
                                            .build());
      this.eventDetailsList.add(EventDetails.builder()
                                            .id("2")
                                            .title("event-title-2")
                                            .build());
   }

   public List<EventDetails> getEvents() {
      return eventDetailsList;
   }
}
