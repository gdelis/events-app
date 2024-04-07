package com.gdelis.events.controller;

import com.gdelis.events.response.EventDetailsResponse;
import com.gdelis.events.service.EventsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

   private final EventsService eventsService;

   public EventsController(EventsService eventsService) {
      this.eventsService = eventsService;
   }

   @GetMapping
   public Flux<EventDetailsResponse> getEvents() {
      return eventsService.getEvents()
                          .map(EventDetailsResponse::from);
   }
}

