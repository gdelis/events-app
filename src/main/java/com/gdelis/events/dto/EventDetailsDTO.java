package com.gdelis.events.dto;

import com.gdelis.events.domain.EventDetails;
import lombok.Builder;

@Builder
public record EventDetailsDTO(String id, String title) {

   public static EventDetails from(final EventDetailsDTO eventDetailsDTO) {
      return EventDetails.builder()
                         .id(eventDetailsDTO.id())
                         .title(eventDetailsDTO.title())
                         .build();
   }
}
