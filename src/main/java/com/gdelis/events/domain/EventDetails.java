package com.gdelis.events.domain;

import com.gdelis.events.repository.dao.EventDetailsDAO;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record EventDetails(Integer id, String title, LocalDateTime startDate, LocalDateTime endDate) {

   public static EventDetails from(final EventDetailsDAO eventDetailsDAO) {
      return EventDetails.builder()
                         .id(eventDetailsDAO.id())
                         .title(eventDetailsDAO.title())
                         .startDate(eventDetailsDAO.startDate())
                         .endDate(eventDetailsDAO.endDate())
                         .build();
   }
}
