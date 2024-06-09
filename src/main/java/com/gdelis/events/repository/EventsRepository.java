package com.gdelis.events.repository;

import com.gdelis.events.domain.EventDetails;
import java.util.List;

public interface EventsRepository {
   List<EventDetails> findAll();

   EventDetails findById(Integer eventId);

   void deleteById(Integer eventId);
}
