package com.gdelis.events;

import lombok.Builder;

@Builder
public record EventDetails(String id, String title) {
}
