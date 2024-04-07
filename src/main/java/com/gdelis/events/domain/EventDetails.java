package com.gdelis.events.domain;

import lombok.Builder;

@Builder
public record EventDetails(String id, String title) {
}
