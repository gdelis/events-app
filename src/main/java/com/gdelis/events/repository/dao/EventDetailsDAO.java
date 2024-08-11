package com.gdelis.events.repository.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// JPA entities can not be records because NoArgument constructor is needed
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EventDetailsDAO {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String title;
   private String location;
   private LocalDateTime startDate;
   private LocalDateTime endDate;
}
