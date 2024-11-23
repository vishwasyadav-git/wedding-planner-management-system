package com.scaler.weddingplanner.controllers;

import com.scaler.weddingplanner.dtos.EventDTO;
import com.scaler.weddingplanner.mapper.EventMapper;
import com.scaler.weddingplanner.models.Event;
import com.scaler.weddingplanner.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventDTO> addEvent(@RequestBody EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        Event savedEvent = eventService.addEvent(event);
        return ResponseEntity.ok(EventMapper.toDTO(savedEvent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(event -> ResponseEntity.ok(EventMapper.toDTO(event)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/upcoming")
    public List<EventDTO> getUpcomingEvents() {
        return eventService.getUpcomingEvents()
                .stream()
                .map(EventMapper::toDTO)
                .toList();
    }

    @GetMapping("/completed")
    public List<EventDTO> getCompletedEvents() {
        return eventService.getCompletedEvents()
                .stream()
                .map(EventMapper::toDTO)
                .toList();
    }


}

