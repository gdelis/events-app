package com.gdelis.events.dto;

import lombok.Builder;

@Builder
public record EventDetailsDTO(String id, String title, String startDate, String endDate) {
}
