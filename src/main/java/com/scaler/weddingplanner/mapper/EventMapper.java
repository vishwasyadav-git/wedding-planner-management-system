package com.scaler.weddingplanner.mapper;

import com.scaler.weddingplanner.dtos.EventDTO;
import com.scaler.weddingplanner.models.Client;
import com.scaler.weddingplanner.models.Event;

public class EventMapper {

    // Convert Entity to DTO
    public static EventDTO toDTO(Event event) {
        return new EventDTO(
                event.getId(),
                event.getType(),
                event.getDate(),
                event.getClient().getId() // Assuming Event has a reference to Client
        );
    }

    // Convert DTO to Entity
    public static Event toEntity(EventDTO eventDTO) {
        Event event = new Event();
        event.setType(eventDTO.getType());
        event.setDate(eventDTO.getDate());

        // Create a Client reference to set the clientId in the entity
        Client client = new Client();
        client.setId(eventDTO.getClientId());
        event.setClient(client);

        return event;
    }
}

