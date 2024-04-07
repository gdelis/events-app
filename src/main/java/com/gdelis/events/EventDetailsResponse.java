package com.gdelis.events;

import lombok.Builder;

@Builder
public record EventDetailsResponse(String id, String title){}
