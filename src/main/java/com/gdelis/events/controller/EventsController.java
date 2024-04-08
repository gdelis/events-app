package com.gdelis.events.controller;

import com.gdelis.events.response.EventDetailsResponse;
import com.gdelis.events.service.EventsService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

   private final EventsService eventsService;

   public EventsController(final EventsService eventsService) {
      this.eventsService = eventsService;
   }

   @GetMapping
   public ResponseEntity<List<EventDetailsResponse>> getEvents() {
      return ResponseEntity.ok(eventsService.getEvents()
                                            .stream()
                                            .map(EventDetailsResponse::from)
                                            .toList());
   }

   @GetMapping("/{id}")
   public ResponseEntity<EventDetailsResponse> getEventById(@PathVariable(name = "id") final String eventId) {
      return ResponseEntity.ok(EventDetailsResponse.from(eventsService.getEventById(eventId)));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteEventById(@PathVariable(name = "id") final String eventId) {
      return ResponseEntity.ok(eventsService.deleteEventById(eventId));
   }
}

