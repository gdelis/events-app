package com.gdelis.events.controller;

import com.gdelis.events.response.EventDetailsResponse;
import com.gdelis.events.service.EventsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

   private final EventsService eventsService;

   public EventsController(final EventsService eventsService) {
      this.eventsService = eventsService;
   }

   @GetMapping
   public Flux<EventDetailsResponse> getEvents() {
      return eventsService.getEvents()
                          .map(EventDetailsResponse::from);
   }

   @GetMapping("/{id}")
   public Mono<EventDetailsResponse> getEventById(@PathVariable(name = "id") final String eventId) {
      return eventsService.getEventById(eventId)
                          .map(EventDetailsResponse::from);
   }

   @DeleteMapping("/{id}")
   public void deleteEventById(@PathVariable(name = "id") final String eventId){
      eventsService.deleteEventById(eventId);
   }
}

