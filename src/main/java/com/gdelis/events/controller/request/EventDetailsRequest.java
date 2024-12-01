package com.gdelis.events.controller.request;

import com.gdelis.events.domain.EventDetails;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record EventDetailsRequest(Integer id, String title, LocalDateTime startDate, LocalDateTime endDate) {

   public static EventDetails to(final EventDetailsRequest request) {
      return EventDetails.builder()
                         .id(request.id())
                         .title(request.title())
                         .startDate(request.startDate())
                         .endDate(request.endDate())
                         .build();
   }
}

