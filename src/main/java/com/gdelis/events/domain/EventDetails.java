package com.gdelis.events.domain;

import com.gdelis.events.dao.EventDetailsDAO;
import lombok.Builder;

@Builder
public record EventDetails(String id, String title, String startDate, String endDate) {

   public static EventDetails from(final EventDetailsDAO eventDetailsDAO) {
      return EventDetails.builder()
                         .id(eventDetailsDAO.id())
                         .title(eventDetailsDAO.title())
                         .startDate(eventDetailsDAO.startDate())
                         .endDate(eventDetailsDAO.endDate())
                         .build();
   }
}
