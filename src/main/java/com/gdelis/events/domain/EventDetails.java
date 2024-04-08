package com.gdelis.events.domain;

import com.gdelis.events.dto.EventDetailsDTO;
import lombok.Builder;

@Builder
public record EventDetails(String id, String title, String startDate, String endDate) {

   public static EventDetails from(final EventDetailsDTO eventDetailsDTO) {
      return EventDetails.builder()
                         .id(eventDetailsDTO.id())
                         .title(eventDetailsDTO.title())
                         .startDate(eventDetailsDTO.startDate())
                         .endDate(eventDetailsDTO.endDate())
                         .build();
   }
}
