package com.scaler.weddingplanner.services;

import com.scaler.weddingplanner.models.Event;
import com.scaler.weddingplanner.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        if (event.getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Event date cannot be in the past.");
        }
        return eventRepository.save(event);
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> getEventsByClientId(Long clientId) {
        return eventRepository.findByClientId(clientId);
    }

    public List<Event> getUpcomingEvents() {
        return eventRepository.findByDateAfter(LocalDate.now());
    }

    public List<Event> getCompletedEvents() {
        return eventRepository.findByDateBefore(LocalDate.now());
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

