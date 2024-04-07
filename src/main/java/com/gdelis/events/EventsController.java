package com.gdelis.events;

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
   public Flux<EventDetails> getEvents() {
      return Flux.fromIterable(eventsService.getEvents());
   }
}

