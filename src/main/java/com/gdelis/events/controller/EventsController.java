package com.gdelis.events.controller;

import com.gdelis.events.controller.request.EventDetailsRequest;
import com.gdelis.events.controller.response.EventDetailsResponse;
import com.gdelis.events.service.EventsService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

   private final EventsService eventsService;

   public EventsController(final EventsService eventsService) {
      this.eventsService = eventsService;
   }

   @GetMapping
   public ResponseEntity<List<EventDetailsResponse>> getEvents(
       @RequestParam(value = "location", required = false) final String location,
       @RequestParam(value = "start", required = false) final LocalDateTime startDate,
       @RequestParam(value = "end", required = false) final LocalDateTime endDate) {

      //eventsService.getEvents(location , startDate, endDate)

      List<EventDetailsResponse> eventDetailsResponses = eventsService.getEvents()
                                                                      .stream()
                                                                      .map(EventDetailsResponse::from)
                                                                      .toList();

      return ResponseEntity.ok(eventDetailsResponses);
   }

   @GetMapping("/{id}")
   public ResponseEntity<EventDetailsResponse> getEventById(@PathVariable(name = "id") final Integer eventId) {
      return ResponseEntity.ok(EventDetailsResponse.from(eventsService.getEventById(eventId)
                                                                      .orElseThrow(() -> new RuntimeException(
                                                                          "Event with id " + eventId + " not found"))));
   }

   @PostMapping
   public ResponseEntity<EventDetailsResponse> createEvent(@RequestBody final EventDetailsRequest request) {
      return null;
   }
}

