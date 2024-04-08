package com.gdelis.events.dao;

import lombok.Builder;

@Builder
public record EventDetailsDAO(String id, String title, String startDate, String endDate) {
}
