package com.gdelis.events.repository;

import com.gdelis.events.repository.dao.EventDetailsDAO;
import java.time.LocalDateTime;
import java.util.concurrent.Future;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<EventDetailsDAO, Integer> {

   Streamable<EventDetailsDAO> findByTitle(String title);

   @Async
   Future<EventDetailsDAO> findDistinctByTitleAndStartDate(String title, LocalDateTime startDate);
}
