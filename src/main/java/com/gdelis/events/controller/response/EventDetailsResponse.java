package com.gdelis.events.controller.response;

import com.gdelis.events.domain.EventDetails;
import lombok.Builder;

@Builder
public record EventDetailsResponse(Integer id, String title, String startDate, String endDate) {

   public static EventDetailsResponse from(final EventDetails eventDetails) {
      return EventDetailsResponse.builder()
                                 .id(eventDetails.id())
                                 .title(eventDetails.title())
                                 .startDate(eventDetails.startDate())
                                 .endDate(eventDetails.endDate())
                                 .build();
   }
}

