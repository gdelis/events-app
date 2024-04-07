package com.gdelis.events.response;

import com.gdelis.events.domain.EventDetails;
import lombok.Builder;

@Builder
public record EventDetailsResponse(String id, String title) {

   public static EventDetailsResponse from(final EventDetails eventDetails) {
      return EventDetailsResponse.builder()
                                 .id(eventDetails.id())
                                 .title(eventDetails.title())
                                 .build();
   }
}

