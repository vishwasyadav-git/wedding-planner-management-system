package com.weddingplanner.repositories;

import com.weddingplanner.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Find all events by a specific client
    List<Event> findByClientId(Long clientId);

    // Find all events occurring on or after the given date
    List<Event> findByDateAfter(LocalDate date);

    // Find all events filtered by type
    List<Event> findByType(String type);

    List<Event> findByDateBefore(LocalDate now);
}
