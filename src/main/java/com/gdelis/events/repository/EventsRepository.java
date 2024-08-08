package com.gdelis.events.repository;

import com.gdelis.events.repository.dao.EventDetailsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<EventDetailsDAO, Integer> {
}
