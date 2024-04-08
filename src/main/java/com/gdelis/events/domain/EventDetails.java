package com.gdelis.events.domain;

import com.gdelis.events.dto.EventDetailsDTO;
import lombok.Builder;

@Builder
public record EventDetails(String id, String title) {

   public static EventDetails from(final EventDetailsDTO eventDetailsDTO) {
      return EventDetails.builder()
                         .id(eventDetailsDTO.id())
                         .title(eventDetailsDTO.title())
                         .build();
   }
}
