package com.gdelis.events.repository.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public record EventDetailsDAO(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id,
    String title,
    LocalDateTime startDate,
    LocalDateTime endDate) {
}
