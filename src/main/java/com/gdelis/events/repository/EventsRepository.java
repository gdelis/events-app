package com.gdelis.events.repository;

import com.gdelis.events.repository.dao.EventDetailsDAO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<EventDetailsDAO, Integer> {

   Streamable<EventDetailsDAO> findByTitle(String title);

   Streamable<EventDetailsDAO> findByLocation(String location);

   Streamable<EventDetailsDAO> findByLocationAndStartDate(String location, LocalDateTime startDate);

   Streamable<EventDetailsDAO> findByLocationAndStartDateAndEndDate(String location, LocalDateTime startDate,
                                                                    LocalDateTime endDate);

   Streamable<EventDetailsDAO> findByStartDateBetween(LocalDateTime startDate, LocalDateTime endDate);

   Streamable<EventDetailsDAO> findByTitleLike(String title);

   @Async
   Future<EventDetailsDAO> findDistinctByTitleAndStartDate(String title, LocalDateTime startDate);

   @Query(value = "SELECT * FROM events WHERE start_date IS NOT NULL AND end_date IS NULL",
       nativeQuery = true)
   List<EventDetailsDAO> findNeverEndingEvents();

   //@Modifying
   //@Query(value = "UPDATE events SET end_date=:'2025-01-01' WHERE end_date IS NULL",
   //    nativeQuery = true)
   //int updateEndDate();
}
